isEmpty :: [a] -> Bool
isEmpty xs 
    | length xs == 0 = True
    | otherwise = False

insert :: Eq a => a -> [a] -> [a]
insert x [] = [x]
insert n xs 
    | elem n xs = xs
    | otherwise = n:xs

delete :: Eq a => a -> [a] -> [a]
delete x [] = []
delete n (x:xs)
    | elem n (x:xs) && n == x = xs
    | elem n (x:xs) && n /= x = x : delete n xs 
    | otherwise = (x:xs)


isElem :: (Eq a) => a -> [a] -> Bool
isElem n xs = elem n xs 

empty :: [a]
empty = []

s1 = [1,2,3]
s2 = [1,2]

union :: (Eq a) => [a] -> [a] -> [a]
union xs ys = xs ++ [y | y <- ys, not(isElem y xs)]

intersection :: (Eq a) => [a] -> [a] -> [a]
intersection xs [] = []
intersection xs (y:ys)
    | isElem y xs = y : intersection xs ys
    | otherwise = intersection xs ys

difference :: (Eq a) => [a] -> [a] -> [a]
difference xs [] = xs
difference xs (y:ys)
    | isElem y xs = difference (delete y xs) ys
    | otherwise = difference xs ys

isSubset :: (Eq a) => [a] -> [a] -> Bool -- Mira si el segundo conjunto es subconjunto del primero
isSubset xs [] = True
isSubset xs ys = and [isElem y xs | y <- ys]
