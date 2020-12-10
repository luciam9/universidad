package dataStructures.priorityQueue;

public class NonSortedLinkedPriorityQueue <T extends Comparable<? super T>> implements PriorityQueue<T>{


    static private class Node<E> {
        E elem;
        NonSortedLinkedPriorityQueue.Node<E> next;
        public Node(E x) {
            elem = x;
            next = null;
        }
    }

    private Node<T> first;
    private int nElem;

    public NonSortedLinkedPriorityQueue (){

        first = null;
        nElem = 0;
    }

    @Override
    public boolean isEmpty() {
        return nElem == 0;
    }

    @Override
    public void enqueue(T x) {

        NonSortedLinkedPriorityQueue.Node<T> node = new NonSortedLinkedPriorityQueue.Node<>(x);
        if(isEmpty()){
            first = node;

        } else {
            NonSortedLinkedPriorityQueue.Node<T> aux = first;
            NonSortedLinkedPriorityQueue.Node<T> prev = null;
            int i = 0;
            while((aux != null) && i<nElem) { // x>=aux.elem. Advance while x's priority is less or equal to element in aux node
                aux = aux.next;
                i++;
            }
            aux.next = node;
        }
        nElem++;
    }

    @Override
    public T first() {

        if(isEmpty())
            throw new EmptyPriorityQueueException("first on empty priority queue");
        else
            return first.elem;
    }

    @Override
    public void dequeue() {

        if(isEmpty())
            throw new EmptyPriorityQueueException("dequeue on empty priority queue");
        else {
            first = first.next;
            nElem--;
        }

    }
}
