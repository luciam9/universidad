package dataStructures.set;

import java.util.Arrays;
import java.util.Iterator;

public class ArraySet<T> implements Set{

    protected T[] elements;
    protected int nElem;
    private static final int DEFAULT_INITIAL_CAPACITY = 128;

    public ArraySet(){

        elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        nElem = 0;
    }

    private void ensureCapacity() {
        if (nElem >= elements.length) {
            elements = Arrays.copyOf(elements, 2*elements.length);
        }
    }

    @Override
    public boolean isEmpty() {
        return nElem==0;
    }

    @Override
    public int size() {
        return nElem;
    }
    @Override
    public void insert(Object x) {

        if(!Arrays.asList(elements).contains(x)){
            ensureCapacity();
            T elem = (T) x;

            boolean encontrado = false;
            int i =0;

            Arrays.asList(elements).set(i, elem);
        }
    }

    @Override
    public boolean isElem(Object x) {
        return Arrays.asList(elements).contains(x);
    }

    @Override
    public void delete(Object x) {

        if(Arrays.asList(elements).contains(x)){
            int j = Arrays.asList(elements).indexOf(x);
            for(int i = j; i<nElem-1; i++){

               elements[i] = elements[i+1];
            }

            nElem--;
        }
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(elements).iterator();
    }
}
