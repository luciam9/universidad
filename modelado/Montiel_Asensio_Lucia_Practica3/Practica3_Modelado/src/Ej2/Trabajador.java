package Ej2;

public abstract class Trabajador {

    protected String nombre;
    protected String nSegSocial;
    protected float salario;

    public Trabajador(String nombre, String nSegSocial, float salario){

        this.nombre = nombre;
        this.nSegSocial = nSegSocial;
        this.salario = salario;
    }

    public float nomina(){

        return salario;
    }

    public abstract void incrementar();
}
