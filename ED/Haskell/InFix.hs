module InFix (
 evaluateInfix
 ) where

import Expression
import DataStructures.Stack.LinearStack as S

sample :: Expression
sample = [LeftP, LeftP, Value 4, Mul, Value 5,RightP, Dif, Value 6, RightP]


evaluateInfix :: Expression -> Integer
evaluateInfix expression = evaluateInfix' expression S.empty S.empty

evaluateInfix' :: Expression -> Stack Integer -> Stack Item -> Integer
evaluateInfix' [] enteros operaciones 
    | isEmpty operaciones = S.top enteros
    | otherwise = error "Expresion erroena"
evaluateInfix' (x:expression) enteros operaciones 
    | x == Add || x == Mul || x == Dif = evaluateInfix' expression enteros (S.push x operaciones)
    | x == LeftP = evaluateInfix' expression enteros operaciones
    | x == RightP = evaluateInfix'' (expression) (S.top enteros) (S.top (S.pop enteros)) (S.top operaciones) (S.pop enteros) (S.pop operaciones)  -- evaluateInfix' expression (S.push (operate operador elem2 elem1)) operaciones
    | otherwise = evaluateInfix' expression (S.push (value x) enteros) operaciones
    where
        evaluateInfix'' :: Expression ->  Integer -> Integer -> Item -> Stack Integer -> Stack Item -> Integer
        evaluateInfix'' expression elem1 elem2 operador enteros operaciones = evaluateInfix' expression (S.push (operate operador elem2 elem1) enteros) operaciones


operate :: Item -> Integer -> Integer -> Integer
operate Add x y = x + y
operate Mul x y = x * y
operate Dif x y = x - y


retVal :: Item -> Integer
retVal (Value a) = a

