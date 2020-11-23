import dataStructures.stack.ArrayStack;
import dataStructures.stack.Stack;

public class PostFix {
    public static void main(String[] args) {
        Item [] sample = {
                new Data(5),
                new Data(6),
                new Data(2),
                new Dif(),
                new Data(3),
                new Mul(),
                new Add()};
        System.out.println(evaluate(sample));
    }

    static int evaluate(Item[] exprList){
        Stack<Integer> pila = new ArrayStack<>();
        for (int i = 0; i < exprList.length; i++) {
            if (exprList[i].isData()){
                int n = exprList[i].getValue();
                pila.push(n);
            }
            if(exprList[i].isOperation()){
                int top1 = pila.top();
                pila.pop();
                int top2 = pila.top();
                pila.pop();

                pila.push(exprList[i].evaluate(top1,top2));
            }
        }


        return pila.top();
    }
}
