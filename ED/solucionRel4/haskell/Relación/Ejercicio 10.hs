import qualified DataStructures.Dictionary.AVLDictionary as AVL

data Dict a b = Empty | Node a b (Dict a b) deriving Show

empty :: Dict a b
empty = Empty


isEmpty :: Dict a b -> Bool
isEmpty empty = True
otherwise = False


insert :: a -> b -> Dict a b -> Dict a b
insert a b d = AVL.insert a b d


delete :: a -> Dict a b -> Dict a b
delete = undefined


get :: a -> Dict a b -> Maybe b
get = undefined


keys :: Dict a b -> [a]
keys = undefined


values :: Dict a b -> [b]
values = undefined


keyValues :: Dict a b -> [(a,b)]
keyValues = undefined


mapValues :: (b -> c) -> Dict a b -> Dict a b
mapValues = undefined