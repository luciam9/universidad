package dataStructures.queue;

import dataStructures.stack.*;

public abstract class TwoStacksQueue<T> implements Queue<T>{

    private Stack<T> st1;
    private Stack<T> st2;
    private int nElem;
    private T first;

    public TwoStacksQueue() {

        st1 = new ArrayStack<T>();
        st2 = new ArrayStack<T>();
        first = null;
    }

    public boolean isEmpty(){

        return st1.isEmpty();
    }

    public void mkValid(){

        if(st1.isEmpty()){

            for(int i = 0; i<nElem; i++){

               T elem = st2.top();
               st1.push(elem);
               st2.pop();
            }
        }

    }
    public void enqueue(T x){

        st2.push(x);
        nElem++;
        mkValid();
        first = st1.top();

    }

    public void dequeue(){

        if(st1.isEmpty()){

            throw new EmptyQueueException("dequeue on empty queue");
        }

        st1.pop();
    }

    public T first(){
        if(st1.isEmpty()){

            throw new EmptyQueueException("dequeue on empty queue");
        }
        return st1.top();
    }

    @Override public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length()+1);
        String s = className+"(";


        return s+=st1.toString();
    }

}
