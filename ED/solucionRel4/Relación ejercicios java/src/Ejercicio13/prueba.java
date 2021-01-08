package Ejercicio13;

public class prueba {
    public static void main(String[] args) {
        AVLbag<Integer,Integer> b = new AVLbag<>();
        b.insert(5);
        b.insert(5);
        b.delete(5);
        b.delete(5);
        System.out.print(b);
    }
}
