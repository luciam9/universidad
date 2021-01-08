package Ej11;

public class TuplaGenerica <A, B>{

    A uno;
    B dos;

    public TuplaGenerica (A a, B b){

        uno = a;
        dos = b;
    }

    public A _1(){

        return uno;
    }

    public B _2(){

        return dos;
    }

    @Override
    public String toString(){

        return "Tuple2(" + _1() + ", " + _2() + ")";
    }
}
