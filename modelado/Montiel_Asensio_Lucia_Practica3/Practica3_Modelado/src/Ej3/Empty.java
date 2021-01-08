package Ej3;

public class Empty extends Estado{


    @Override
    public void put(Pieza pieza, Bandeja bandeja) {

        if(bandeja.size()>1){

            bandeja.setEstado(new Normal());
        }else{

            bandeja.setEstado(new Full());
        }
        bandeja.getPiezas().add(pieza);
    }

    @Override
    public Pieza get(Bandeja bandeja) {
        throw new RuntimeException("No se puede recoger nada de una bandeja vacía");
    }
}
