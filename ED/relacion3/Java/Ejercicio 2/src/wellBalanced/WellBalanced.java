package wellBalanced;

import dataStructures.stack.*;

//@SuppressWarnings("unused")

public class WellBalanced {
    private final static String OPEN_PARENTHESES = "{[(";
    private final static String CLOSED_PARENTHESES = "}])";

    public static void main(String[] args) {

        Stack<Character> s1 = new ArrayStack<Character>(10);
        System.out.println(wellBalanced("lsijdf(asad)a[]asd[df(fdgsasd))", s1));
    }

    public static boolean wellBalanced(String exp, Stack<Character> stack) {

        for (int i = 0; i <= exp.length() - 1; i++) {
            char caracter = exp.charAt(i);
            if (isOpenParentheses(caracter)) {
                stack.push(caracter);
            } else if (isClosedParentheses(caracter)) {
                if (match(stack.top(), caracter)) {
                    stack.pop();
                } else {
                    throw new RuntimeException("Se te ha olvidado poner un ),],}");
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isOpenParentheses(char c) {
        return OPEN_PARENTHESES.contains(Character.toString(c));
    }

    public static boolean isClosedParentheses(char c) {
        return CLOSED_PARENTHESES.contains(Character.toString(c));
    }

    public static boolean match(char x, char y) {
        return OPEN_PARENTHESES.indexOf(Character.toString(x)) == CLOSED_PARENTHESES
                .indexOf(Character.toString(y));
    }
}