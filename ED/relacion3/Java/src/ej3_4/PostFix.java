package ej3_4;

import dataStructures.stack.ArrayStack;
import dataStructures.stack.Stack;

public class PostFix {

    public static void main (String [] args){

        Item [] sample = {
                new Data(5),
                new Data(6),
                new Data(2),
                new Dif(),
                new Data(3),
                new Mul(),
                new Add() };

        System.out.println(postFix(sample));
    }

    public static int postFix(Item[] exprList){

        Stack<Item> st = new ArrayStack<>();

        for(int i = 0; i<exprList.length; i++){

            if(exprList[i].isData()){

                st.push(exprList[i]);
            }
            else if(exprList[i].isOperation()){

                int d1 = st.top().getValue();
                st.pop();
                int d2 = st.top().getValue();
                st.pop();
                int res = exprList[i].evaluate(d2, d1);
                Data d = new Data(res);
                st.push(d);
            }
        }
        return st.top().getValue();
    }
}
