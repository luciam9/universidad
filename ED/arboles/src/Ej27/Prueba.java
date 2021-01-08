package Ej27;

import dataStructures.searchTree.BST;

public class Prueba {

    public static void main (String[] args){

        BST t = new BST();

        t.insert(1, 1);
        t.insert(4, 4);
        t.insert(2, 2);
        t.insert(6, 6);
        t.insert(8, 8);
        t.insert(3, 3);

        System.out.println(t);
        System.out.println(t.floor(7));
        System.out.println(t.ceiling(5));
        /*System.out.println(t.rank(5));*/
        /*t.deleteMin();*/
        t.deleteMinim();
        System.out.println(t);
    }
}
