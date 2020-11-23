import Data.List(intercalate)

data Bag a = Empty | Node a Int (Bag a)

empty :: Bag a
empty = Empty

isEmpty :: Bag a -> Bool
isEmpty Empty = True
isEmpty _ = False

insert :: (Ord a) => a -> Bag a -> Bag a
insert x Empty = Node x 1 Empty
insert x (Node y n b) 
    | x == y = (Node y (n+1) b)
    | x > y = Node y n (insert x b)
    | otherwise = Node x 1 (Node y n b)


ocurrences :: (Ord a) => a -> Bag a -> Int
ocurrences x Empty = 0
ocurrences x (Node y n Empty)
    | x == y = n
    | otherwise = ocurrences x Empty
ocurrences x (Node y n b) 
    | x == y = n
    | otherwise = ocurrences x b


delete :: (Ord a) => a -> Bag a -> Bag a
delete _ Empty = Empty
delete x (Node y n b)
    | isElem x (Node y n b) == False = (Node y n b)
    | isElem x (Node y n b) && x == y && n == 1 = b
    | isElem x (Node y n b) && x == y && n /= 1 = (Node y (n-1) b)
    | isElem x (Node y n b) && x /= y = Node y n (delete x b)


isElem :: (Ord a) => a -> Bag a -> Bool
isElem x Empty = False
isElem x (Node y n b)
    | x == y = True
    | otherwise = isElem x b


diferencia :: (Ord a) => Bag a -> Bag a -> Bag a
diferencia Empty Empty = Empty
diferencia Empty _ = Empty
diferencia x Empty = x
diferencia (Node x n b) (Node y m v)
    | x == y && (n - m) <= 0 = diferencia b v
    | x == y && (n - m) > 0 = Node x (n-m) (diferencia b v)
    | x > y = diferencia (Node x n b) v
    | x < y = diferencia b (Node y m v)


union :: (Ord a) => Bag a -> Bag a -> Bag a
union Empty Empty = Empty 
union Empty x = x
union x Empty = x

union bag@(Node x n b) bag2@(Node y m v) 
    | m == 0 = union bag v
    | otherwise = union (insert y bag) (Node y (m-1) v)

-- ! Se Podría hacer mas eficiente si no usamos el insert y aprovechamos que las mochilas están ordendas para hacerlo


interseccion :: (Ord a) => Bag a -> Bag a -> Bag a
interseccion Empty Empty = Empty
interseccion Empty _ = Empty
interseccion _ Empty = Empty
interseccion bag@(Node x n b) bag2@(Node y m v) 
    | x == y = Node x (min n m) (interseccion b v)
    | x < y = Node x n (interseccion b bag2)
    | otherwise =  interseccion bag v 


s1 = insert 5 (insert 6 (insert 5 (insert 5 Empty)))
s2 = insert 6 (insert 6 (insert 4 (insert 5 Empty)))

instance (Show a) => Show (Bag a) where
    show b = "Bag (" ++ intercalate ", " (aux b) ++ ")"
        where
            aux Empty = []
            aux (Node x y q) = nveces x y ++ aux q

            nveces x y 
                | y == 0 = error "Un elemento aparece 0 veces"
                | y == 1 = show x : []
                | otherwise = show x : nveces x (y-1)