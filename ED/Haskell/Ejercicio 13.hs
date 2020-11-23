module FoldStackQueue where
import qualified DataStructures.Stack.LinearStack as S

foldrStack :: (a -> b -> b) -> b -> S.Stack a -> b
foldrStack f z s
 | S.isEmpty s = z
 | otherwise = S.top s `f` foldrStack f z (S.pop s)


listToStack :: [a]-> S.Stack a
listToStack xs = foldr (S.push) (S.empty) xs 

stackToList :: S.Stack a -> [a]
stackToList stack = foldrStack (:) [] stack


--Todo 

mapStack :: (a -> b) -> S.Stack a -> S.Stack b
mapStack f s = foldrStack (opera f) (S.empty) s
    where
        opera f a b = S.push (f a) b

{- 
*Tambien funciona
mapStack :: (a -> b) -> S.Stack a -> S.Stack b
mapStack f stack = listToStack (map f (stackToList stack))-}

sizeStack :: S.Stack a -> Int
sizeStack s = foldrStack (suma) 0 s
        where
            suma :: a -> Int -> Int
            suma a n = n+1