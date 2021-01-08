-------------------------------------------------------------------------------
-- Student's name: Javier Ortuño Roig
--
-- Maxiphobic Heaps
-- Data Structures. Grado en Informática. UMA.
-------------------------------------------------------------------------------

module DataStructures.Heap.MaxiphobicHeap
  ( Heap
  , empty
  , isEmpty
  , minElem
  , delMin
  , insert
  , merge
  , mkHeap
  ) where

import Test.QuickCheck

data Heap a  = Empty | Node a Int (Heap a) (Heap a) deriving Show

-- number of elements in tree rooted at node
weight :: Heap a -> Int
weight Empty           = 0
weight (Node _ w _ _)  = w


singleton :: a -> Heap a
singleton x  = Node x 1 Empty Empty


empty :: Heap a
empty = Empty


isEmpty :: Heap a -> Bool
isEmpty Empty = True
isEmpty _ = False


insert :: (Ord a) => a -> Heap a -> Heap a
insert x h = merge (singleton x) h


minElem :: Heap a -> a
minElem Empty = error "monticulo vacio"
minElem (Node x p a b) = x


delMin :: (Ord a) => Heap a -> Heap a
delMin (Node a w hl hr) = merge hl hr


merge :: (Ord a) => Heap a -> Heap a -> Heap a -- T(n) = log (3/2) n
merge Empty Empty = Empty
merge Empty b = b
merge a Empty = a
merge h@(Node x w hl hr) h'@(Node x' w' hl' hr')
    | x <= x' = (Node x ws h1 (merge h2 h3))
    | otherwise = (Node x' ws h1' (merge h2' h3'))
    where
      sortHeaps :: Heap a -> Heap a -> Heap a -> (Heap a, Heap a, Heap a)
      sortHeaps h1 h2 h3
        | w1 >= w2 && w1 >= w3 = (h1,h2,h3)
        | w2 >= w3 && w2 >= w1 = (h2,h1,h3)
        | otherwise = (h3,h1,h2)
          where 
            w1 = weight h1
            w2 = weight h2
            w3 = weight h3
        
      ws = w + w'
      (h1,h2,h3) = sortHeaps hl hr h' 
      (h1',h2',h3') = sortHeaps hl' hr' h

{-Otra forma  
merge :: (Ord a) => Heap a -> Heap a -> Heap a -- T(n) = log (3/2) n
merge Empty Empty = Empty
merge Empty b = b
merge a Empty = a
merge h@(Node a w hl hr) h'@(Node c w' hl' hr')
    | a <= c && weight hl >= weight hr && weight hl >= w' = (Node a (weight hr + w') hl (merge hr h'))
    | a <= c && weight hr >= weight hl && weight hr >= w' =  (Node a (w + weight hl) hr (merge h hl))
    | a <= c && w' >= weight hr && w' >= weight hl = (Node a (weight hr + weight hl) h' (merge hr hl))
    | a > c && weight hl >= weight hr && weight hl >= w = (Node c (w + weight hr) hl (merge hr h))
    | a > c && weight hr >= weight hl && weight hr >= w =  (Node c (w + weight hl) hr (merge h hl))
    | a > c && w >= weight hr && w >= weight hl = (Node c (weight hr + weight hl) h (merge hr hl))
-}

-- Efficient O(n) bottom-up construction for heaps
mkHeap :: (Ord a) => [a] -> Heap a
mkHeap []  = empty
mkHeap xs  = mergeLoop (map singleton xs)
  where
    mergeLoop [h]  = h
    mergeLoop hs   = mergeLoop (mergePairs hs)

    mergePairs []         = []
    mergePairs [h]        = [h]
    mergePairs (h:h':hs)  = merge h h' : mergePairs hs

-------------------------------------------------------------------------------
-- Generating arbritray Heaps
-------------------------------------------------------------------------------

instance (Ord a, Arbitrary a) => Arbitrary (Heap a) where
  arbitrary  = do
    xs <- arbitrary
    return (mkHeap xs)
