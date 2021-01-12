package Ej2;

public class Pensionista extends Trabajador{

    public Pensionista (String nombre, String numSegSocial, float salario){

        super(nombre, numSegSocial, salario);
    }

    @Override
    public void incrementar() {
        super.salario *= 1.04;
    }
}
