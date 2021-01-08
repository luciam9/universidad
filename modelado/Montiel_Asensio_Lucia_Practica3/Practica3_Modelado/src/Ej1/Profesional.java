package Ej1;

import java.util.*;

public class Profesional {

    private List <Acceso> accesos;

    public  Profesional(){

        accesos = new ArrayList<>();
    }

    public void addAcceso(Acceso a){

        accesos.add(a);
    }

    public void removeAcceso(Acceso a){

        if(accesos.contains(a)){

            accesos.remove(a);
        }else{

            throw new RuntimeException("El acceso no existe");
        }
    }

    public Iterable<Expediente> expedientesAccedidos(){

        List<Expediente> exp = new ArrayList<>();
        for(Acceso a : accesos){

            exp.add(a.getExpediente());
        }

        return exp;
    }

}
