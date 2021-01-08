package Ejercicio11;

public class tuplaGenerica <A,B>{
    A uno;
    B dos;

    public tuplaGenerica(A a, B b) {
        uno = a;
        dos = b;
    }

    public A A_1(){return uno;}
    public B A_2(){return dos;}

    public String toString() {
        return "Tuple2(" + A_1() + ", " + A_2() + ")";
    }
}
