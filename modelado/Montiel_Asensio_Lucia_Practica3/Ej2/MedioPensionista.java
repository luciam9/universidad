package Ej2;

public class MedioPensionista extends Trabajador{

    private Activo activo;
    private Pensionista pensionista;

    public MedioPensionista(String nombre, String numSegSocial, float salarioActivo, float salarioPensionista){

        super(nombre, numSegSocial, salarioActivo + salarioPensionista);
        this.activo = new Activo(nombre, numSegSocial, salarioActivo);
        this.pensionista = new Pensionista (nombre, numSegSocial, salarioPensionista);
    }

    @Override
    public void incrementar() {

        activo.incrementar();;
        pensionista.incrementar();
        super.salario = activo.nomina() + pensionista.nomina();
    }
}
