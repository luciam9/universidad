package dataStructures.heap;

import java.util.Arrays;

public class MonticuloMaxifobico <T extends Comparable<? super T>> implements Heap<T>{

    private int size;
    private T elements[];

    public MonticuloMaxifobico(int n){

        elements = (T[]) new Comparable[n];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if(size==elements.length)
            elements = Arrays.copyOf(elements,2*elements.length);
    }

    @Override
    public void insert(T x) {
        ensureCapacity();
        elements[size] = x;
        heapifyUp(size);
        size++;
    }

    // true if elems[idx1] < elems[idx2]
    private boolean lessThan(int idx1, int idx2) {
        return elements[idx1].compareTo(elements[idx2]) < 0;
    }

    //swaps elements in array at positions idx1 and idx2
    private void swap(int idx1, int idx2) {
        T aux = elements[idx1];
        elements[idx1] = elements [idx2];
        elements[idx2] = aux;
    }

    private void heapifyUp(int idx) {
        while(!isRoot(idx)) {
            int idxParent =	parent(idx);

            if(lessThan(idx,idxParent)) {
                swap(idx,idxParent);
                idx = idxParent; // move to parent node for next iteration
            } else if(hasLeftChild(idx)){

                if(lessThan(idx+1, idx+2)){

                    swap(idx+1, idx+2);
                }
            }else idx =- 1;
        }
    }

    @Override
    public T minElem() {
        return elements[0];
    }

    @Override
    public void delMin() {


    }

    private static final int ROOT_INDEX = 0;

    private static boolean isRoot(int idx) {
        return idx==ROOT_INDEX;
    }

    private static int parent(int idx) { //returns index for parent of node with index idx
        return (idx-1) / 2;
    }

    private static int leftChild(int idx) { //returns index for left child of node with index idx
        return 2*idx+1;
    }

    private static int rightChild(int idx) { //returns index for right child of node with index idx
        return 1+leftChild(idx);
    }

    private boolean isNode(int idx) { //returns true if idx corresponds index of a node in tree
        return idx<size;
    }

    private boolean hasLeftChild(int idx) { //returns true if idx has a left child
        return leftChild(idx)<size;
    }

    private boolean isLeaf(int idx) { //returns true if idx is index of a leaf node
        return !hasLeftChild(idx);
    }
}
