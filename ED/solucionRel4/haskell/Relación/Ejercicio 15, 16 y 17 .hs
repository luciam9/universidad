data TreeB a = EmptyB | NodeB a (TreeB a) (TreeB a) deriving (Show, Eq)

empty :: TreeB a
empty = EmptyB

mirror :: TreeB a -> TreeB a
mirror EmptyB = EmptyB
mirror (NodeB x l r) = (NodeB x (mirror r) (mirror l) )

isSimmetricB :: (Eq a) => TreeB a -> Bool
isSimmetricB EmptyB = True
isSimmetricB (NodeB _ _ EmptyB) = False
isSimmetricB (NodeB _ EmptyB _) = False
isSimmetricB (NodeB x l r) 
    | l == mirror r = True
    | otherwise = False


leafsB :: (Eq a) => TreeB a -> [a]
leafsB EmptyB = []
leafsB (NodeB x l r) 
    | l == EmptyB && r == EmptyB = [x] ++ leafsB l ++ leafsB r
    | otherwise = leafsB l ++ leafsB r


internalsB :: (Eq a) => TreeB a -> [a]
internalsB EmptyB = []
internalsB (NodeB x l r) 
    | l == EmptyB && r == EmptyB = internalsB l ++ internalsB r
    | otherwise = [x] ++ internalsB l ++ internalsB r