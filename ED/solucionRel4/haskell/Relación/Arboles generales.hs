data Tree a = Empty | Node a [Tree a] deriving Show

tamaño:: Tree a -> Int
tamaño Empty = 0
tamaño (Node a xs) = 1 + sum [tamaño y | y <- xs]

isEmpty :: Tree a -> Bool
isEmpty Empty = True
isEmpty otherwise = False

c = Node 5 [(Node 1 [(Node 4 [Empty])]), (Node 2 [Empty])]

hojas :: Tree a -> [a]
hojas Empty = []
hojas t = hojas' t []
    where 
        hojas' :: Tree a -> [a] -> [a]
        hojas' Empty xs = xs
        hojas' (Node y ys) xs 
            | length ys == 0 || or [isEmpty a | a <- ys] = y : xs
            | otherwise = concat [hojas' a xs | a <- ys]


maxi :: (Ord a) => Tree a -> a
maxi t = maximum (maximo t)
    where
        maximo :: Tree a -> [a]
        maximo Empty = []
        maximo t = maximo' t []
            where 
                maximo' :: Tree a -> [a] -> [a]
                maximo' Empty xs = xs
                maximo' (Node y ys) xs = concat [maximo' a (y:xs) | a <- ys]



preOrden :: Tree a -> [a]
preOrden Empty = []
preOrden (Node a ts) = [a] ++ (foldl (++) [] (map preOrden ts))

anchura:: Tree a -> [a]
anchura Empty = []
anchura (Node a xs) = [a] ++ (foldl (++) [] (map anchura xs))

