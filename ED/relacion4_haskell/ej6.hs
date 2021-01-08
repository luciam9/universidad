import DataStructures.Util.Random

data BST a = Empty | Node a (BST a) (BST a) deriving Show

insert :: (Ord a) => a -> BST a -> BST a
insert x' Empty = Node x' Empty Empty
insert x' (Node x lt rt) 
    | x' < x = Node x (insert x' lt) rt
    | x' > x = Node x lt (insert x' rt)
    | otherwise Node x' lt rt

bst :: [Int] -> BST Int
bst xs = crearBST xs Empty
    where 
        crearBST [] t = t
        crearBST (x:xs) t = crearBST xs (insert x t)


altura :: Bst a -> Int
altura Empty = 0
altura (Node x l r) = 1 + maximum [altura l, altura r]


alturaMedia :: Int -> Int
alturaMedia x = div (sumaAltura x) x
    where
        sumaAltura x 
            | x == 1 = altura (bst (take x (randomsR (0,49) x)))
            | x > 1 = altura (bst (take x (randomsR (0,49) x))) + sumaAltura (x-1)