package Ejercicio5;

import dataStructures.searchTree.BST;

import java.util.Random;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    System.out.print ("Introduce n: ");
    int n = teclado.nextInt();

    double altura = 0;
    int media = 10;
    for (int i = 0; i < media; i++) {
        altura += alturaBSTrandom(n);
    }
    System.out.println("La media es: " + altura/media);
    }


    public static int alturaBSTrandom(int n){
        BST<Integer, Integer> a = new BST<>();

        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            int rndNum = rnd.nextInt(100);
            a.insert(rndNum, rndNum);
        }
        return a.height();
    }
}
