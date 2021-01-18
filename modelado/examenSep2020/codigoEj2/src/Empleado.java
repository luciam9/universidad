import java.util.*;

public class Empleado {

    List<ContratoEnCurso> contratos;

    public Empleado(){

        contratos = new ArrayList<>();
    }

    protected void addContrato(ContratoEnCurso c){

        contratos.add(c);
    }

    protected void removeContrato(ContratoEnCurso c){

        contratos.remove(c);
    }

    public Enumeration<ContratoEnCurso> getContratoEnCurso() {
        return java.util.Collections.enumeration(contratos);
    }
}
