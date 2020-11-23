
-- * Ejercicio 1
module WellBalanced where

    import Test.QuickCheck

    import DataStructures.Stack.LinearStack

    wellBalanced :: String -> Bool
    wellBalanced xs = wellBalanced' xs empty

    wellBalanced' :: String -> Stack Char -> Bool
    wellBalanced' [] s = isEmpty s
    wellBalanced' (x:xs) s 
        | x == '(' = wellBalanced' xs (push x s)
        | x == ')' && top s == '(' = wellBalanced' xs (pop s)
        | x == ')' && top s /= '(' = False
        
        | x == '[' = wellBalanced' xs (push x s)
        | x == ']' && top s == '[' = wellBalanced' xs (pop s)
        | x == ']' && top s /= '[' = False
        
        | x == '{' = wellBalanced' xs (push x s)
        | x == '}' && top s == '{' = wellBalanced' xs (pop s)
        | x == '}' && top s /= '{' = False

        | otherwise = wellBalanced' xs s

