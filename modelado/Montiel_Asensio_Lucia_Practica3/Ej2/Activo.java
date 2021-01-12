package Ej2;

public class Activo extends Trabajador{

    public Activo(String nombre, String nSegSocial, float salario){

        super(nombre, nSegSocial, salario);
    }

    @Override
    public void incrementar() {
        super.salario *= 1.02;
    }
}
