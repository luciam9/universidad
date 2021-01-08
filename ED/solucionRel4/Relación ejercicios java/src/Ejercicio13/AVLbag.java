package Ejercicio13;

import dataStructures.searchTree.AVL;
import dataStructures.searchTree.SearchTree;

public class AVLbag <K extends Comparable<? super K>, V> {

    public SearchTree<K,Integer> tree;

    public AVLbag() {
        tree = new AVL<K, Integer>();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    public void insert (K k) {
        if (tree.isElem(k)) {
            tree.insert(k, tree.search(k) + 1);
        } else {
            tree.insert(k, 1);
        }
    }

    public void delete (K k) {
        if (tree.isElem(k)) {
            if (tree.search(k) == 1) {
                tree.delete(k);
            } else {
                tree.insert(k, tree.search(k) - 1);
            }
        }
    }
    public Integer occurrences (K k) {
        return tree.search(k);
    }

    public String toString() {
        return tree.toString();
    }
}
