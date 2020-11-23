module FoldStackQueue where
    
import qualified DataStructures.Queue.LinearQueue as Q

import qualified DataStructures.Stack.LinearStack as S

foldrStack :: (a -> b -> b) -> b -> S.Stack a -> b
foldrStack f z s
    | S.isEmpty s = z
    | otherwise = S.top s `f` foldrStack f z (S.pop s)


foldrQueue :: (a -> b -> b) -> b -> Q.Queue a -> b
foldrQueue f z q
    | Q.isEmpty q = z
    | otherwise = f (Q.first q) (foldrQueue f z (Q.dequeue q))

listToQueue :: [a]-> Q.Queue a
listToQueue xs = foldr (Q.enqueue) (Q.empty) xs

stackToQueue :: S.Stack a-> Q.Queue a
stackToQueue s = foldrStack (Q.enqueue) (Q.empty) s

queueToStack :: Q.Queue a -> S.Stack a
queueToStack q = foldrQueue (S.push) (S.empty) q

queueToList :: Q.Queue a -> [a]
queueToList q = foldrQueue (:) [] q


-- todo
mapQueue :: (a -> b) -> Q.Queue a -> Q.Queue b
mapQueue f q = foldrQueue (opera f) Q.empty q
    where
        opera f a b = Q.enqueue (f a) b