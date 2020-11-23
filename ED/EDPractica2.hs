-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- PRACTICA 2ª (Características de la Programación Funcional)
--
-- (completa y sustituye los siguientes datos)
-- Titulación: Grado en Ingeniería del Software.
-- Alumno: MONTIEL ASENSIO, LUCIA
-- Fecha de entrega:  27 | 10 | 2020
--
-- Ejercicios resueltos de la Relación : 4, 11, 13, 14, 22, 34
--
-------------------------------------------------------------------------------
module Practica2 where

import Test.QuickCheck



-------------------------------------------------------------------------------
-- Ejercicio 4
-------------------------------------------------------------------------------
distintos :: Ord a => [a] -> Bool
distintos [] = True
distintos [x] = True
distintos (x:xs) = x /= head xs && distintos(tail xs)


-------------------------------------------------------------------------------
-- Ejercicio 11
-------------------------------------------------------------------------------
--a)
take' :: Int -> [a] -> [a]
take' n xs = [x | (p, x) <- zip [0..n-1] xs]

--b)
drop' :: Int -> [a] -> [a]
drop' n xs = [x |(p, x) <- zip [0..length xs] xs, p>=n]

--c)
p1_TakeDrop xs n = n>=0 ==> (take' n xs) ++ (drop' n xs) == xs


-- Ejercicio 13
-------------------------------------------------------------------------------
desconocida :: (Ord a) => [a] -> Bool
desconocida xs = and [ x<=y | (x,y) <- zip xs (tail xs) ]
-- Qué hace?
--Indica si la lista xs está ordenada de mayor a menor o no ya que devuelve otra lista donde
--aparece si el elemento de después de otro es mayor o no que este en cuestión.

-------------------------------------------------------------------------------
-- Ejercicio 14
-------------------------------------------------------------------------------
-- a)
inserta :: (Ord a) => a -> [a] -> [a]
inserta x s = (takeWhile (<x) s) ++ (x : (dropWhile (<x) s))

-- b)
inserta' :: (Ord a) => a -> [a] -> [a]
inserta' x [] = x
inserta' x (y:ys)
  | x<y = x : (y:ys)
  | otherwise = y ++ inserta' (x ys)

--c)
p1_inserta x xs = desconocida xs ==> desconocida (inserta x xs)

-- e)

ordena :: (Ord a) => [a] -> [a]
ordena xs = foldr (inserta) [] xs


-------------------------------------------------------------------------------
-- Ejercicio 22
-------------------------------------------------------------------------------
--a)
binarios ::Integer -> [String]
binarios 0 = [""]
binarios x | x > 0 = ["0" ++ x | x <- binarios (x-1)] ++ ["1" ++ x | x <- binarios (x-1)]

--b)
p_binarios n = n>=0 && n<=10 ==>
                    long xss == 2^n
                    && distintos xss
                    && all (`todosEn` "01") xss
      where xss = binarios n

-------------------------------------------------------------------------------
-- Ejercicio 37
-------------------------------------------------------------------------------

type Izdo = Double
type Dcho = Double
type Epsilon = Double
type Función = Double -> Double
biparticion :: Función -> Izdo -> Dcho -> Epsilon -> Double

biparticion f a b epsilon
  | long < epsilon    = c
  | Función (c a b) == 0.0 = c a b
  | (a<0 && (c a b)>0) || (a>0 && (c a b)<0) = biparticion(f a (c a b))
  | (b<0 && (c a b)>0) || (b>0 && (c a b)<0) = biparticion(f b (c a b))

  where
      long = b - a
      c :: Double -> Double -> Double
      c a b = (a+b)/2



