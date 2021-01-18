import qualified DataStructures.Dictionary.AVLDictionary as AVL

data Dict a b = Empty | Node a b (Dict a b) deriving Show

empty :: Dict a b
empty = Empty

isEmpty :: Dict a b -> Bool
isEmpty Empty = True
otherwise = False 

insert :: a -> b-> Dict a b -> Dict a b 
insert x y t = AVL.insert x y t 

delete :: a -> Dict a b -> Dict a b 
delete x t = AVL.delete x t 

get :: a -> Dict a b -> Maybe b