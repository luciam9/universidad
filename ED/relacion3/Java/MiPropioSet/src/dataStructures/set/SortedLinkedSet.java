/**
 * @author 
 *
 * A set implemented using without-repetitions linear sorted linked structure. 
 */

package dataStructures.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedLinkedSet<T extends Comparable<? super T>> implements Set<T> {

    static private class Node<E> {
        E elem; // element stored in this node
        Node<E> next; // reference to next node in linked structure

        Node(E x, Node<E> node) {
            elem = x;
            next = node;
        }
    }

    // Invariant for this implementation: elements in set must be stored in a linked
    // list of nodes
    // (without repetitions). Additionally, nodes in linked list must be sorted
    // according to the values
    // of their elements.

    private Node<T> first; // reference to node storing first (smaller) element
    private int size; // number of elements included in this set

    // Default constructor: constructs an empty set
    public SortedLinkedSet() {
        first = null;
        size = 0;
    }

    // Copy constructor: constructs another set which is a deep copy of argument.
    // This constructor should construct another set with same elements as
    // parameter.
    // New nodes for each element in new set should be allocated using new and
    // linked accordingly. Note that the parameter is an abstract set hence the only
    // way to access its elements is by using an iterator.
    public SortedLinkedSet(Set<T> set) {
        // todo creo que está mal
        this();
        for (T x : set) {
            this.insert(x);
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Inserts a new element in this set. Linked nodes are sorted according to their
    // values
    public void insert(T item) {
        Node<T> previous = null;
        Node<T> current = first;

        // Advance until end of linked list or until finding a larger element
        while (current != null && current.elem.compareTo(item) < 0) {
            previous = current;
            current = current.next;
        }

        // check if item is already in set
        boolean found = (current != null) && current.elem.equals(item);

        if (!found) { // avoid nodes with repeated elements
            if (previous == null) // Insert new element in first position of linked structure
                first = new Node<>(item, first);
            else // insert new element after previous
                previous.next = new Node<>(item, current);
            size++;
        }
    }

    public boolean isElem(T item) {

        Node<T> current = first;

        while (current != null && current.elem.compareTo(item) < 0){
            current = current.next;
        }
        return current != null && current.elem.equals(item);
    }

    public void delete(T item) {
    //todo falta hacer el else y no se si lodemas esta bien
        if (isElem(item)){
            boolean encontrado = false;

            Node<T> previous = null;
            Node<T> current = first;

            if (isElem(item)) {
                while (!encontrado && current != null) {
                    if (!current.elem.equals(item)) {
                        previous = current;
                        current = current.next;
                    } else {
                        if(previous !=null){
                            previous.next = current.next;
                        }else{
                            first = first.next;
                        }
                        encontrado = true;
                    }
                }
            }
        }
    }

    /**
     * Iterator over elements in this set. Note that {@code remove} method is not
     * supported. Note also that linked structure should not be modified during
     * iteration as iterator state may become inconsistent.
     * s
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<T> iterator() {
        return new LinkedSetIterator();
    }

    private class LinkedSetIterator implements Iterator<T> {
        @SuppressWarnings("unused")

        Node<T> current;

        public LinkedSetIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T x = current.elem;
            current = current.next;
            return x;
        }
    }

    // This method should modify this set so that it contains the union of its
    // elements plus those in the set parameter. Note that the parameter is an
    // abstract set hence the only way to access its elements is by using an
    // iterator.
    public void union(Set<T> set) {
        Iterator <T> meDan= set.iterator();
            while(meDan.hasNext()){
                this.insert(meDan.next());
            }



    }

    // This method should modify this set so that it contains the intersection of
    // its
    // elements and those in the set parameter. Note that the parameter is an
    // abstract set hence the only way to access its elements is by using an
    // iterator.
    public void intersection(Set<T> set) {
        Iterator <T> mio = this.iterator();

        while(mio.hasNext()){
            T elemento = mio.next();
            if(!set.isElem(elemento)){
                this.delete(elemento);
            }
        }
    }

    // This method should modify this set so that it contains the difference of its
    // elements minus those in the set parameter. Note that the parameter is an
    // abstract set hence the only way to access its elements is by using an
    // iterator.
    public void difference(Set<T> set) {
        Iterator <T> it = set.iterator();

        while(it.hasNext()){
            T elemento = it.next();
            if(this.isElem(elemento)){
                delete(elemento);
            }
        }


    }

    public String toString() {
        String className = getClass().getSimpleName();
        String text = className + "(";
        for (Node<T> p = first; p != null; p = p.next) {
            text += p.elem + (p.next != null ? "," : "");
        }
        return text + ")";
    }
}
