-- *Estamos hacienod un set desordenado
import Data.List (intercalate)

data Set a = Empty | Node a (Set a)

isEmpty :: Set a -> Bool
isEmpty Empty = True
isEmpty _ = False

insert :: Eq a => a -> Set a -> Set a
insert x Empty = (Node x Empty)
insert x s = if isElem x s then s else (Node x s)

delete :: Eq a => a -> Set a -> Set a
delete x Empty = empty
delete x s@(Node y d)
    | isElem x s && x == y = d
    | isElem x s && x /= y = (Node y (delete x d))
    | otherwise = s

isElem :: (Eq a) => a -> Set a -> Bool
isElem _ Empty = False
isElem x (Node y s) = if x == y then True else isElem x s

empty :: Set a
empty = Empty

s1 = Node 3 (Node 4 (Node 1 Empty))
s2 = Node 3 (Node 1 Empty)

instance (Show a) => Show (Set a) where
    show s = "Set(" ++ intercalate ", " (aux s) ++ ")"
        where
            aux Empty = []
            aux (Node x s) = show x : aux s


union :: (Ord a) => Set a -> Set a -> Set a
union s Empty = s
union set1 (Node x s) 
    | isElem x set1 = union set1 s
    | otherwise = union (insert x set1) s

difference :: (Ord a) => Set a -> Set a -> Set a
difference s Empty = s
difference set1 (Node x s) 
    | isElem x set1 = difference (delete x set1) s
    | otherwise = difference set1 s

intersection :: (Ord a) => Set a -> Set a -> Set a
intersection s Empty = Empty
intersection set1 (Node x s) 
    | isElem x set1 = Node x (intersection set1 s)
    | otherwise = intersection set1 s


isSubset :: (Ord a) => Set a -> Set a -> Bool --El segundo set subSet del primero
isSubset s Empty = True
isSubset set (Node x s) 
    | isElem x set = True && isSubset set s
    | otherwise = False

