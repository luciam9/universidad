package dataStructures.set;

import dataStructures.stack.LinkedStack;

import java.util.Iterator;

public class LinkedSet<T extends Comparable<? super T>> implements Set<T>{
    static private class Node<E> {
        E elem;
        LinkedSet.Node<E> next;
        public Node(E x, LinkedSet.Node<E> node) {
            elem = x;
            next = node;
        }
    }
    private Node<T> first;
    private int size;

    public LinkedSet(){

        first = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T x) {

        if(!isElem(x)){

            first = new LinkedSet.Node<>(x, first);
            size++;
        }

    }



    @Override
    public boolean isElem(T x) {

        boolean encontrado = false;
        Node<T> current = first;
        int i = 0;

        while (!encontrado && i < size) {

            if (first.elem.compareTo(x) < 0) {

                current = current.next;
                i++;

            } else {

                encontrado = true;
            }

        }

        return encontrado;
    }

    @Override
    public void delete(T x) {

        if(isElem(x)) {
            LinkedSet.Node<T> previous = null;
            LinkedSet.Node<T> current = first;

            while (current != null && current.elem.compareTo(x) < 0) {
                previous = current;
                current = current.next;
            }

                if (previous == null) {
                    first = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;

        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
