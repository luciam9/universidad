package Bag;

public class PruebaBag {

    public static void main (String [] args) {
        Bag<Integer> b = new LinkedBag();

        b.insert(1);
        b.insert(1);
        System.out.println(b);
        b.insert(2);
        System.out.println(b);
    }


}
