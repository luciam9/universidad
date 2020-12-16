package dataStructures.searchTree;

public class Saco<K extends Comparable<? super K>> {

    private AVL<K, Integer> elements;
    private int nElem;

    public Saco(){

        elements = new AVL<>();
        nElem = 0;
    }

    public boolean isEmpty(){

        return nElem == 0;
    }

    public void insert(K x){



    }

    public boolean isElem(K x){

        int elem = elements.search(x);

        if(elem = null){
            return false;
        }
        else{

            return true;
        }
    }
}
