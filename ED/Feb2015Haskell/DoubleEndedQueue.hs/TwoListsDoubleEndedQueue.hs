-------------------------------------------------------------------------------
-- Estructuras de Datos. Grado en Informática, IS e IC. UMA.
-- Examen de Febrero 2015.
--
-- Implementación del TAD Deque
--
-- Apellidos:
-- Nombre:
-- Grado en Ingeniería ...
-- Grupo:
-- Número de PC:
-------------------------------------------------------------------------------

module TwoListsDoubleEndedQueue
   ( DEQue
   , empty
   , isEmpty
   , first
   , last
   , addFirst
   , addLast
   , deleteFirst
   , deleteLast
   ) where

import Prelude hiding (last)
import Data.List(intercalate)
import Test.QuickCheck

data DEQue a = DEQ [a] [a]

-- Complexity:
empty :: DEQue a
empty = DEQ [] []

-- Complexity:
isEmpty :: DEQue a -> Bool
isEmpty (DEQ [] []) = True
isEmpty (DEQ _ _) = False 

-- Complexity:
addFirst :: a -> DEQue a -> DEQue a
addFirst x (DEQ xs ys) = DEQ (x:xs) ys

-- Complexity:
addLast :: a -> DEQue a -> DEQue a
addLast x (DEQ xs ys) = DEQ xs (x:ys)


ultimo :: [a] -> a
ultimo [x] = x
ultimo (x:xs) = ultimo xs
ultimo [] = error "lista vacía"

-- Complexity:
first :: DEQue a -> a
first (DEQ (x:xs) _) = x
first (DEQ [] ys) = ultimo ys

-- Complexity:
last :: DEQue a -> a
last (DEQ _ (y:ys)) = y
last (DEQ [][]) = error "lista vacía"
last (DEQ xs []) = ultimo xs

eliminaUltimo :: [a] -> [a]
eliminaUltimo (x:xs) = x:(eliminaUltimo xs)

-- Complexity:
deleteFirst :: DEQue a -> DEQue a
deleteFirst (DEQ (x:xs) ys) = (DEQ xs ys) 
deleteFirst (DEQ [] []) = error "cola vacía"
deleteFirst (DEQ [] ys) = (DEQ [] (eliminaUltimo ys))


-- Complexity:
deleteLast :: DEQue a -> DEQue a
deleteLast _ = undefined



instance (Show a) => Show (DEQue a) where
   show q = "TwoListsDoubleEndedQueue(" ++ intercalate "," [show x | x <- toList q] ++ ")"

toList :: DEQue a -> [a]
toList (DEQ xs ys) =  xs ++ reverse ys

instance (Eq a) => Eq (DEQue a) where
   q == q' =  toList q == toList q'

instance (Arbitrary a) => Arbitrary (DEQue a) where
   arbitrary =  do
      xs <- listOf arbitrary
      ops <- listOf (oneof [return addFirst, return addLast])
      return (foldr id empty (zipWith ($) ops xs))
