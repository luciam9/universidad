package Ej1;

import java.util.*;

public class Expediente {

    private List<Acceso> accesos;

    public Expediente(){

        accesos = new ArrayList<>();
    }

    public void addAcceso(Acceso acceso) {
        this.accesos.add(acceso);
    }

    public void removeAcceso(Acceso acceso){

       if(accesos.contains(acceso)){

           accesos.remove(accesos);
       }
       else{

           throw new RuntimeException("El acceso no existe");
       }
    }

    public Iterable<Acceso> getAccesosExpediente(){

        return accesos;
    }

}
