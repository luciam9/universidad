package ej3_4;

import dataStructures.stack.*;

public class Infix {

    static int evaluate(Item[] exprList) {
        Stack<Integer> stackDatas = new ArrayStack<Integer>();
        Stack<Item> stackOperations = new ArrayStack<Item>();
        for (Item expr : exprList) {
            if (expr.isData()) {

                stackDatas.push(expr.getValue());

            } else if (expr.isOperation()) {

                stackOperations.push(expr);

            } else if (expr.isParentheses()) {

                if(expr.isRightP()){

                    int d1 = stackDatas.top();
                    stackDatas.pop();

                    int d2 = stackDatas.top();
                    stackDatas.pop();

                    Item op = stackOperations.top();
                    stackOperations.pop();

                    stackDatas.push(op.evaluate(d2, d1));
                }
            }
        }

        if(stackOperations.isEmpty()){

            return stackDatas.top();

        }else{

            throw new RuntimeException("La expresión no está bien construida");
        }


    }
    public static void main(String [] args) {

        Item [] sample = {
                new LeftP(),
                new LeftP(),
                new Data(4),
                new Mul(),
                new Data(5),
                new RightP(),
                new Dif(),
                new Data(6),
                new RightP()};

        System.out.println(evaluate(sample));
    }
}
