package Ej3;

public class Normal extends Estado{

    @Override
    public void put(Pieza pieza, Bandeja bandeja) {
        if(bandeja.getPiezas().size() == bandeja.getPiezas().size()-1){

            bandeja.setEstado(new Full());
        }
        bandeja.getPiezas().add(pieza);
    }

    @Override
    public Pieza get(Bandeja bandeja) {

        Pieza p = bandeja.getPiezas().get(0);

        if(bandeja.getPiezas().size() == 1){

            bandeja.setEstado(new Empty());
        }

        bandeja.getPiezas().remove(0);

        return p;
    }
}
