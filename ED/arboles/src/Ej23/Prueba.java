package Ej23;

import dataStructures.searchTree.BST;

import java.util.ArrayList;
import java.util.List;

public class Prueba {

    public static void main (String[] args){

        List<Integer> preOrden = new ArrayList<>();
        preOrden.add(0,2);
        preOrden.add(1,1);
        preOrden.add(2,3);
        preOrden.add(3,4);
        preOrden.add(4,6);
        List <Integer> inOrden = new ArrayList<>();
        inOrden.add(0,3);
        inOrden.add(1,1);
        inOrden.add(2,4);
        inOrden.add(3,2);
        inOrden.add(4,6);

        int root = preOrden.get(0);
        BST<Integer, Integer> t = new BST<>();
        t.insert(root, root);
        inOrden.add(inOrden.indexOf(root), -1);

        crearArbol(preOrden, inOrden, t);

        System.out.println(t);

    }

    public static void crearArbol(List<Integer> preOrden, List<Integer> inOrden, BST t){

        for(Integer i: preOrden){

            t.insert(i, i);
        }

    }

}
