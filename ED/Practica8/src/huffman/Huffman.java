package huffman;
/**
 * Huffman trees and codes.
 *
 * Data Structures, Grado en Informatica. UMA.
 *
 *
 * Student's name:
 * Student's group:
 */

import dataStructures.dictionary.AVLDictionary;
import dataStructures.dictionary.Dictionary;
import dataStructures.list.ArrayList;
import dataStructures.list.LinkedList;
import dataStructures.list.List;
import dataStructures.priorityQueue.BinaryHeapPriorityQueue;
import dataStructures.priorityQueue.PriorityQueue;
import dataStructures.tuple.Tuple2;
import java.util.*;

public class Huffman {

    // Exercise 1  
    public static Dictionary<Character, Integer> weights(String s) {

        Dictionary<Character, Integer> dic = new AVLDictionary<>();

        for(int i=0; i<s.length(); i++){

            Character c = s.charAt(i);

            if(dic.isDefinedAt(c)){

                dic.insert(c, 1+dic.valueOf(c));
            }else{

                dic.insert(c, 1);
            }

        }

        return dic;
    }

    // Exercise 2.a 
    public static PriorityQueue<WLeafTree<Character>> huffmanLeaves(String s) {

        PriorityQueue<WLeafTree<Character>> queue = new BinaryHeapPriorityQueue<>();

        Dictionary<Character, Integer> dic = weights(s);

        for(Tuple2<Character, Integer> i: dic.keysValues()){

            WLeafTree<Character> l = new WLeafTree<>(i._1(), i._2());
            queue.enqueue(l);
        }

        return queue;
    }

    // Exercise 2.b  
    public static WLeafTree<Character> huffmanTree(String s) {


        PriorityQueue<WLeafTree<Character>> queue = huffmanLeaves(s);

        if(diferentes(queue)){

            while(!queue.isEmpty()){

               WLeafTree<Character> pelem = queue.first();
               queue.dequeue();
               WLeafTree<Character> selem = queue.first();
               queue.dequeue();
               WLeafTree elem = new WLeafTree(pelem, selem);
               queue.enqueue(elem);
            }

        }else{

            throw new HuffmanException("El árbol no tiene suficientes elementos");
        }


    }

    private static boolean diferentes(PriorityQueue<WLeafTree<Character>> queue){

        PriorityQueue<WLeafTree<Character>> q = queue;
        q.dequeue();
        if(!q.isEmpty()){

            return true;
        }else{

            return false;
        }

    }

    // Exercise 3.a 
    public static Dictionary<Character, List<Integer>> joinDics(Dictionary<Character, List<Integer>> d1, Dictionary<Character, List<Integer>> d2) {

        for(Tuple2<Character, List<Integer>> i : d2.keysValues()){

            d1.insert(i._1(), i._2());
        }

        return d1;
    }

    // Exercise 3.b  
    public static Dictionary<Character, List<Integer>> prefixWith(int i, Dictionary<Character, List<Integer>> d) {

        for(Tuple2<Character, List<Integer>> j : d.keysValues()){

            List<Integer> list= j._2();
            list.insert(0, i);
            d.insert(j._1(), list);
        }

        return d;
    }

    // Exercise 3.c  
   /* public static Dictionary<Character, List<Integer>> huffmanCode(WLeafTree<Character> ht) {

        while(!ht.isLeaf()){

            if(ht.leftChild()!=null){


            }
        }
        return new AVLDictionary<>()<Character, List<Integer>>();
    }*/

    // Exercise 4  
    public static List<Integer> encode(String s, Dictionary<Character, List<Integer>> hc) {

        ArrayList<Integer> codigo = new ArrayList<>();

        for(int i=0; i<s.length(); i++){

            Character c = s.charAt(i);
            List<Integer> list = hc.valueOf(c);

            for(int j=0; j<list.size(); j++){

                codigo.set(codigo.size(), list.get(i));
            }
        }

        return codigo;
    }

    // Exercise 5 
    public static String decode(List<Integer> bits, WLeafTree<Character> ht) {
        //to do 
    	return null;
    }
}
