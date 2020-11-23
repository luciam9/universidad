module Expression (
 Item (..)
 , Expression
 , value
 , showExpr
 , sample1, sample2
 ) where
data Item = Add | Dif | Mul | Value Integer | LeftP | RightP

type Expression = [Item] 

value :: Item -> Integer
value (Value a) = a

sample1 = [ Value 5, Add, LeftP, Value 6, Dif, Value 2, RightP, Mul, Value 3 ]
sample2 = undefined

showExpr :: Expression -> String
showExpr [] = ""
showExpr (x:xs) = show x ++ showExpr xs

instance Eq Item where
    Add == Add = True
    Dif == Dif = True
    Mul == Mul = True
    LeftP == LeftP = True
    RightP == RightP = True
    _ == _ = False

instance Show Item where
    show Add = "+"
    show Dif = "-"
    show Mul = "*"
    show LeftP = "("
    show RightP = ")"
    show (Value x) = show (value (Value x))

