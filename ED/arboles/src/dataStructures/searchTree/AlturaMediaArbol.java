package dataStructures.searchTree;
import java.util.*;

public class AlturaMediaArbol {

    public static void main(String[] args) {

        BST tree = generaArbol(5);
        System.out.println(tree);
    }

    public int alturaMedia(){

        return 0;
    }

    public static BST generaArbol(int n){

        BST arbol = new BST();

        for(int i=0; i<n; i++){

            Random r = new Random();
            int valor = r.nextInt(n)+1;
            arbol.insert(valor, Integer.toString(valor));

        }

        return arbol;
    }

}
