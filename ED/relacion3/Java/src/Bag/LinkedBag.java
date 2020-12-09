package Bag;

import dataStructures.set.LinkedSet;
import dataStructures.set.SortedLinkedSet;
import dataStructures.stack.LinkedStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LinkedBag<T extends Comparable<? super T>> implements Bag<T>{

    static private class Node<E> {

        E elem;
        Integer nVeces;
        LinkedBag.Node<E> next;
        public Node(E x, Integer n, LinkedBag.Node<E> node) {
            elem = x;
            nVeces = n;
            next = node;
        }
    }

    private Node<T> first;
    private int nElem;

    public LinkedBag(){
        first = null;
        nElem = 0;
    }

    @Override
    public boolean isEmpty() {
        return nElem == 0;
    }

    private boolean isElem(T x){
        boolean encontrado = false;
        LinkedBag.Node<T> current = first;
        int i = 0;

        while (!encontrado && i < nElem  && current!=null) {

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
    public void insert(T x) {


        if(isEmpty()){
            first = new Node<>(x, 1, null);
        }
        else if(isElem(x)){

            LinkedBag.Node<T> current = first;
            LinkedBag.Node<T> previous = null;
           while(current.elem != x && current!=null){

               if(current.next!=null){
               current = current.next;}
           }

           current.nVeces = current.nVeces + 1;
        }
        else{
            LinkedBag.Node<T> current = first;
            LinkedBag.Node<T> previous = null;
            while(current.elem.compareTo(x) < 0 && current != null){

                previous = current;
                current = current.next;

            }

            previous.next = new Node<T>(x, 1, current);
        }
        nElem++;

    }

    @Override
    public int ocurrences(T x) {

        if(isElem(x)){
        LinkedBag.Node<T> current = first;

        while(current.elem != x){

            current = current.next;
        }

            return current.nVeces;
        }

        else{
            throw new RuntimeException("El elemento no está");
        }

    }

    @Override
    public void delete(T x) {

        if(isElem(x)){
            LinkedBag.Node<T> current = first;

            while(current.elem != x){

                current = current.next;
            }

            current = current.next;
            nElem--;
        }

        else{
            throw new RuntimeException("El elemento no está");
        }
    }

    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length()+1);
        String text = className+"(";
        for (LinkedBag.Node<T> p = first; p != null; p = p.next) {
            text += "(" + p.elem + ", "+p.nVeces+")" + (p.next != null ? "," : "");
        }
        return text + ")";
    }

    @Override
    public Iterator<T> iterator() {

      return null;
    }




}
