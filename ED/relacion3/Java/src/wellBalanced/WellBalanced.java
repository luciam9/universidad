package wellBalanced;
import dataStructures.stack.*;

public class WellBalanced {

    private final static String OPEN_PARENTHESES = "{[(";
    private final static String CLOSED_PARENTHESES = "}])";

    public static void main (String [] args){

        String st = "v(hg(jij)hags{ss[dd]dd})";
        ArrayStack<Character> stack = new ArrayStack<>();
        System.out.println(wellBalanced(st, stack));

    }

    public static boolean wellBalanced (String exp, Stack <Character> stack){

        for(int i=0; i<exp.length(); i++){

            char ch = exp.charAt(i);
            if(isOpenParentheses(ch)){

                stack.push(ch);

            }else if(isClosedParentheses(ch)){

                if(match(ch, stack.top())){

                    stack.pop();
                }
            }

        }
        if(stack.isEmpty()){

            return true;
        }else{

            return false;
        }
    }

    public static boolean isOpenParentheses (char c){

        return OPEN_PARENTHESES.indexOf(new Character(c).toString()) >= 0;
    }

    public  static boolean isClosedParentheses(char c){
        return CLOSED_PARENTHESES.indexOf(new Character(c).toString()) >= 0;
    }

    public static boolean match (char x, char y){

        return OPEN_PARENTHESES.indexOf(new Character(x).toString()) ==
                CLOSED_PARENTHESES.indexOf(new Character(y).toString());
    }

}
