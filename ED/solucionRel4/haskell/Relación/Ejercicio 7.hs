import qualified DataStructures.Queue.LinearQueue as C

data Tree a = Empty | Node a (Tree a) (Tree a) deriving Show

levels :: Tree a -> [a]
levels t = levels' (C.enqueue t (C.empty)) t
    where
        levels' cola arbol
            | C.isEmpty cola == True = []
            | otherwise = raiz (C.first cola) : levels' (C.enqueue (izq arbol) (C.enqueue (der arbol) (C.dequeue cola)) )
        
        raiz :: Tree a -> a
        raiz (Node a l r) = a
        izq :: Tree a -> Tree a
        izq (Node a l r) = l
        der :: Tree a -> Tree a
        der (Node a l r) = r

        
c = Node 1 (Node 2 (Node 3 Empty Empty) (Node 4 Empty Empty)) (Node 5 (Node 6 Empty Empty) (Node 7 Empty Empty))
