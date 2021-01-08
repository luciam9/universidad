package Ejercicio4;

import dataStructures.searchTree.BST;

import java.util.Random;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    System.out.print ("Introduce n: ");
    int n = teclado.nextInt();

    BST<Integer, Integer> a = new BST<>();

    for (int i = 0; i < n; i++) {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(100);
        a.insert(rndNum, rndNum);
    }


    System.out.println("La altura mediad de un solo árbol es: " + a.height());
    }

}
