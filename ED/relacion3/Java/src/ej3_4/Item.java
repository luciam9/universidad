package ej3_4;

public abstract class Item {

    public boolean isData( ) {
        return false;
    }
    public boolean isOperation( ) {
        return false;
    }
    public int getValue() {
        throw new UnsupportedOperationException();
    }
    public int evaluate(int a1, int a2) {
        throw new UnsupportedOperationException();
    }

    public boolean isParentheses(){

        return false;
    }

    public boolean isRightP(){

        return false;
    }
}
