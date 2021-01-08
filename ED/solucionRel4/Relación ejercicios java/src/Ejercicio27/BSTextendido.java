package Ejercicio27;

import dataStructures.searchTree.AVL;
import dataStructures.searchTree.SearchTree;

import java.util.Iterator;

public class BSTextendido <K extends Comparable<? super K>, V> {

    private SearchTree<K,V> tree;

    public BSTextendido() {
        tree = new AVL<>();
    }

    public K floor (K key) {
        K anterior = null;

        Iterator<K> it = tree.inOrder().iterator();
        boolean salir = false;
        while (it.hasNext() && !salir) {
            K siguiente = it.next();
            if (siguiente.compareTo(key) == 0) {
                salir = true;
            }
            if (!salir) {
                anterior = siguiente;
            }
        }
        return anterior;
    }
    public K ceiling (K key) {
        boolean encontrado = false;
        Iterator<K> it = tree.inOrder().iterator();

        while (it.hasNext() && !encontrado) {
            if (it.next().compareTo(key) == 0) {
                encontrado = true;
            }
        }
        return it.next();
    }

    public int rank (K key) {
        Iterator <K> it = tree.inOrder().iterator();
        int keysMenores = 0;

        while (it.hasNext()) {
            if (it.next().compareTo(key) < 0) {
                keysMenores++;
            }
        }

        return keysMenores;
    }
    public K select (int i) {
        Iterator <K> it = tree.inOrder().iterator();
        K solucion = null;
        int j = 0;
        while (j <= i) {
            solucion = it.next();
            j++;
        }

        return solucion;
    }
    public void deleteMin() {
        K menor = null;
        Iterator <K> it = tree.inOrder().iterator();
        menor = it.next();
        tree.delete(menor);
    }
    public void deleteMax() {
        K mayor = null;
        Iterator <K> it = tree.inOrder().iterator();

        while (it.hasNext()) {
            mayor = it.next();
        }
        tree.delete(mayor);
    }
    public int size (K lo, K hi) {
        int numeroClavesEnIntervalo = 0;

        for (K key : tree.inOrder()) {
            if (key.compareTo(lo) > 0 && key.compareTo(hi) < 0) {
                numeroClavesEnIntervalo++;
            }
        }

        return numeroClavesEnIntervalo;
    }
}