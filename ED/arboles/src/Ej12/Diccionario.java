package Ej12;

import dataStructures.dictionary.Dictionary;
import dataStructures.searchTree.AVL;
import dataStructures.searchTree.SearchTree;
import dataStructures.tuple.Tuple2;

public class Diccionario <K extends Comparable<? super K>,V> implements Dictionary<K,V> {

    private SearchTree<K,V> tree;

    public Diccionario(){

        tree = new AVL<>();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public void insert(K k, V v) {

        tree.insert(k, v);
    }

    @Override
    public V valueOf(K k) {

        return tree.search(k);
    }

    @Override
    public boolean isDefinedAt(K k) {
        return tree.isElem(k);
    }

    @Override
    public void delete(K k) {

        tree.delete(k);
    }

    @Override
    public Iterable<K> keys() {
        return tree.inOrder();
    }

    @Override
    public Iterable<V> values() {
        return tree.values();
    }

    @Override
    public Iterable<Tuple2<K, V>> keysValues() {
        return tree.keysValues();
    }
}
