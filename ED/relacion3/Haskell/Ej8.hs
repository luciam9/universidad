module Ejercicio8 where --(ax1,ax2)

import Data.List(intercalate)
-- import Test.QuickCheck

data QueueP a = Empty | Node a (QueueP a) --Node representará la prioridad 

empty :: QueueP a
empty = Empty

isEmpty :: QueueP a -> Bool
isEmpty Empty = True
isEmpty _ = False 


enqueue :: Ord a => a -> QueueP a -> QueueP a
enqueue x Empty = Node x Empty
enqueue x (Node y q) 
    | x < y = Node x (Node y q)
    | otherwise = Node y (enqueue x q)

first :: QueueP a -> a
first Empty = error "first on empty queue"
first (Node x _) = x

dequeue :: QueueP a -> QueueP a
dequeue Empty = error "dequeue on empty queue"
dequeue (Node _ q) = q

instance (Show a) => Show (QueueP a) where
    show q = "QueueP(" ++ intercalate "," (aux q) ++ ")"
      where
        aux Empty      =  []
        aux (Node x q) =  show x : aux q



  
--quickCheck (ax1 :: Property)
--quickCheck (ax2 :: Int -> QueueP -> Property)
--quickCheck (ax3 :: Property)
--quickCheck (ax4 :: Property)

--ax1 = True ==> isEmpty empty
--ax2 a q = not (isEmpty (enqueue a q)) 
{-ax3 = first (enqueue a empty) == a
ax4 = dequeue (enqueue a empty) == empty-}

s1 = enqueue 5 (enqueue 3 (enqueue 7 Empty))
