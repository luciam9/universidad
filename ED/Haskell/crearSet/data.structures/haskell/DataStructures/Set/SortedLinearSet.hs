-------------------------------------------------------------------------------
-- Linear implementation of Sets. Nodes are sorted according to
-- value of their elements and elements are non-repeated
--
-- Data Structures. Grado en Informática. UMA.
--
-- Students name:
-------------------------------------------------------------------------------

module DataStructures.Set.SortedLinearSet
  ( Set
  , empty
  , isEmpty
  , size
  , insert
  , isElem
  , delete

  -- to be done lately, fold

  , union
  , intersection
  , difference
  ) where

import Data.List(intercalate)
import Test.QuickCheck

data Set a  = Empty | Node a (Set a)

empty :: Set a
empty  = Empty

isEmpty :: Set a -> Bool
isEmpty Empty = True
isEmpty _ = False

insert :: (Ord a) => a -> Set a -> Set a
insert x Empty  = Node x Empty
insert x (Node y s)
 | x < y        = Node x (Node y s)
 | x == y       = Node y s
 | otherwise    = Node y (insert x s)

-- checks if an element is in set or not
isElem :: (Ord a) => a -> Set a -> Bool
isElem n Empty = False
isElem n (Node y s)  
  | n == y = True
  | otherwise = isElem n s

-- removes an element from a set
delete :: (Ord a) => a -> Set a -> Set a
delete n Empty = Empty
delete n (Node y s) 
  | n < y = Node y s
  | y == n = s
  | otherwise = Node y (delete n s)

-- return number of elements in set
size :: Set a -> Int
size s = size' s 0
  where
    size' :: Set a -> Int -> Int
    size' Empty n = n
    size' (Node y s) n = size' s (n+1)

-- union of two sets
union :: (Ord a) => Set a -> Set a -> Set a
union Empty s2 = s2
union s1 Empty = s1
union (Node x s1) (Node y s2)
  | x == y    = union s1 (Node y s2)
  | x < y     = union s1 (Node x (Node y s2))
  | otherwise = union s1 (Node y (insert x s2))

-- intersection of two sets
intersection :: (Ord a) => Set a -> Set a -> Set a
intersection s1 s2 = intersection' s1 s2 Empty
    where
      intersection' :: (Ord a) => Set a -> Set a -> Set a -> Set a
      intersection' Empty _ s3 = s3
      intersection' _ Empty s3 = s3
      intersection' (Node x s1) (Node y s2) s3
        | x == y = intersection' s1 s2 (insert x s3)
        | x < y = intersection' s1 (Node y s2) s3
        | otherwise = intersection' (Node x s1) s2 s3



-- difference of two sets
difference :: (Ord a) => Set a -> Set a -> Set a
difference Empty _ = Empty
difference s1 Empty = s1
difference (Node x s1) (Node y s2)
  | x == y = difference s1 s2
  | x < y = Node x (difference s1 (Node y s2))
  | x > y = difference (Node x s1) s2

-- Showing a set
instance (Show a) => Show (Set a) where
  show s  = "SortedLinearSet(" ++ intercalate "," (aux s) ++ ")"
    where
      aux Empty       = []
      aux (Node x s)  = show x : aux s

-- Set equality
instance (Eq a) => Eq (Set a) where
  Empty      == Empty         = True
  (Node x s) == (Node x' s')  = x==x' && s==s'
  _          == _             = False

-- This instance is used by QuickCheck to generate random sets
instance (Ord a, Arbitrary a) => Arbitrary (Set a) where
    arbitrary  = do
      xs <- listOf arbitrary
      return (foldr insert empty xs)
