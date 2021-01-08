package Ejercicio23;


import java.util.ArrayList;
import java.util.List;

public class prueba {
    public static void main(String[] args) {
        List<Integer> preOrden = new ArrayList<>();
        preOrden.add(0,2);
        preOrden.add(1,1);
        preOrden.add(2,3);
        preOrden.add(3,4);
        preOrden.add(4,6);
        List <Integer> inOrden = new ArrayList<>();
        inOrden.add(0,3);
        inOrden.add(1,1);
        inOrden.add(2,4);
        inOrden.add(3,2);
        inOrden.add(4,6);

        int root = preOrden.get(0);
        Tree<Integer,Integer> arbol = new Tree<>(root, root);
        inOrden.add(inOrden.indexOf(root), -1);

    }

    public void crearArbol(List<Integer> preOrden, List<Integer> inOrden){
        if (!acabado(preOrden)) {

        }


    }

    private boolean acabado(List<Integer> preOrden) {
        boolean acabado = true;

        int i = 0;
        while (i < preOrden.size() - 1) {
            if (preOrden.get(i) != -1 && acabado) {
                acabado = false;
            }
            i++;
        }
        return acabado;
    }
}

class Tree <K extends Comparable<? super K>, V> {

    K key;
    V value;
    Tree<K, V> left;
    Tree<K, V> right;

    public Tree(K k, V v) {
        key = k;
        value = v;
        left = null;
        right = null;
    }


}
