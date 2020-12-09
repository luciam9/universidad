package ej3_4;

public class Data extends Item{

    private int dato;

    public Data(int n){

        dato = n;
    }

    @Override
    public boolean isData(){

        return true;
    }

    @Override
    public int getValue(){

        return dato;
    }


}
