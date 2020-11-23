-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- PRACTICA 3ª (Características de la Programación Funcional)
--
-- (completa y sustituye los siguientes datos)
-- Titulación: Grado en Ingeniería …………………………………… [Informática | del Software | de Computadores].
-- Alumno: APELLIDOS, NOMBRE
-- Fecha de entrega:  DIA | MES | AÑO
-------------------------------------------------------------------------------
module Practica3 where

import Test.QuickCheck

-------------------------------------------------------------------------------
-- Ejercicio 1. Ejercicio Racional  
-------------------------------------------------------------------------------
data Racional = R Integer Integer
instance Show Racional where
    show (R x y) = show x' ++ "/" ++ show y'
        where R x' y' = normaliza (R x y)

-- Normaliza un racional. Devuelve su expresión irrdeducible y 
-- con signo en el numerador  (gcd x y es el mínimo común múltiplo de x e y) 
normaliza :: Racional -> Racional
normaliza (R x y) 
    |x > 0 && y > 0 = (R (div x (gcd x y)) (div y (gcd x y)))
    |y<0 || y < 0 = (R -(abs (div x (gcd x y))) (abs ((div y (gcd x y)))))

-- Suma dos racionales. Devuelve la expresion canónica del resultado 
sumaRac :: Racional -> Racional -> Racional
sumaRac (R x y) (R z t) = (R ((div denominador y)*x + (div denominador z)*z) denominador)
    where
        denominador = lcm y t

-- resta. Resta dos racionales. Devuelve la expresión canónica del resultado
restaRac :: Racional -> Racional -> Racional
restaRac (R x y) (R z t) = (R ((div denominador y)*x - (div denominador z)*z) denominador)
    where 
        denominador = lcm y t

-- iguales. Completa la definición de ==
instance Eq Racional where
    R x y == R x' y' = undefined

-- menor o igual. Completa la definición de <=
instance Ord Racional where
    R x y <= R x' y' = undefined

-------------------------------------------------------------------------------
-- Ejercicio 2. Ejercicio Dinero
-------------------------------------------------------------------------------
data Dinero = Euros Double | Dolares Double deriving Show

dolaresPorEuro ::Double
dolaresPorEuro = 1.17

-- aEuros. Concierte un dinero en euros
aEuros:: Dinero -> Dinero
aEuros (Euros e) = Euros e
aEuros (Dolares d) = Euros (d / dolaresPorEuro)

-- aDolares. Convierte un dinero en dolares 
aDolares:: Dinero -> Dinero
aDolares (Dolares d) = Dolares d
aDolares (Euros e) = Dolares (e * dolaresPorEuro)

-- sumaDinero. Suma dos cantidades de dinero
sumaDinero :: Dinero -> Dinero -> Dinero
sumaDinero (Dolares d) (Dolares o) = aEuros (Dolares (d+o))
sumaDinero (Euros e) (Euros u) = Euros (e+u)
sumaDinero (Euros e) (Dolares d) = (Euros e + (aEuros (Dolares d)))

-- sumaListaDinero. Suma una lista con dinero
sumaListaDinero :: [Dinero] -> Dinero
sumaListaDinero xs = foldr sumaDinero (Euros 0) xs

-------------------------------------------------------------------------------
-- Ejercicio 3. Ejercicio Complejo 
-- atan2 y x devuelve el arco cuya tangente es y/x
-------------------------------------------------------------------------------
data Complejo = C Double Double | P Double Double 

instance Show Complejo where
    show (C x y)  
        | y == 0 = show x
        | y < 0  = show x ++ show y ++ "i"
        | otherwise = show x ++ "+" ++ show y ++ "i"
    show (P m r) = show (aCartesiana (P m r))

aCartesiana :: Complejo -> Complejo
aCartesiana (C x y) = (C x y)
aCartesiana (P m r) = (C real im)
    where
        real = m * cos r
        im = m * sin r 

aPolar :: Complejo -> Complejo  
aPolar (P m r) = (P m r)
aPolar (C x y) = 

sumaComp :: Complejo -> Complejo -> Complejo
sumaComp c1 c2 = undefined

prodComp :: Complejo -> Complejo -> Complejo
prodComp c1 c2 = undefined

-------------------------------------------------------------------------------
-- Ejercicio 4. Ejercicio Lista 
-------------------------------------------------------------------------------
data List  a = Nil | Cons a (List a) deriving Show

ejemplo:: List Integer
ejemplo = Cons 3 (Cons 5 (Cons 1 (Cons 9 Nil)))

infixr 5 ++>
-- ++> Concatena dos listas
(++>):: List a -> List a -> List a
xs ++> ys = undefined

-- filterList. Se queda con los elementos que cumplan el predicado
filterList :: (a -> Bool) -> List a -> List a 
filterList p xs = undefined

-- mapList. Transforma una lista según una función dada
mapList :: (a -> b) -> List a -> List b
mapList f xs = undefined 

-- aHaskell. Transforma una List a en una [a]
aHaskell :: List a -> [a]
aHaskell xs = undefined

-- aList. Transfurma una [a] en una List a
aList:: [a] -> List a
aList xs = undefined

-------------------------------------------------------------------------------
-- Ejercicio 5. Ejercicio Arbol
-------------------------------------------------------------------------------
data Arbol a = Vacio | Nodo (Arbol a) a (Arbol a) deriving Show

ejemploArbol :: Arbol Integer
ejemploArbol = Nodo (Nodo (Nodo Vacio 7 Vacio) 4 (Nodo Vacio 2 Vacio)) 6 (Nodo Vacio 9 Vacio)

-- nodos Cuenta cuántos nodos hay en el árbol
nodos :: Arbol a -> Int
nodos ar = undefined

-- prof. Determina la profundidad del árbol
prof :: Arbol a -> Int
prof ar = undefined

-- espejo. Crea un arbol que es imagen especular del dado
espejo :: Arbol a -> Arbol a
espejo ar = undefined

-- mapArbol. Aplica la función dada a cada elemento del árbol
mapArbol :: (a -> b) -> Arbol a -> Arbol b
mapArbol f ar = undefined
-------------------------------------------------------------------------------
-- Ejercicio 6. Ejercicio ArbolH
-------------------------------------------------------------------------------
data ArbolH a = Hoja a | NodoH (ArbolH a) (ArbolH a) deriving Show

ejemploArbolH :: ArbolH Integer
ejemploArbolH = NodoH (NodoH (Hoja 4) (NodoH (Hoja 3) (Hoja 5))) (NodoH (NodoH (Hoja 9) (Hoja 4)) (Hoja 2))

-- sumaArbolH. Suma las hojas de un árbolh
sumaArbolH :: Num a => ArbolH a -> a
sumaArbolH ar = undefined

-- mapoArbolH. Aplica la función dada a cada dato del árbolH
mapArbolH :: (a -> b) -> ArbolH a  -> ArbolH b
mapArbolH f ar = undefined

-- arbolHALista. Transforma un ArbolH a en una lista [a]
arbolHALista :: ArbolH a -> [a] 
arbolHALista ar = undefined
