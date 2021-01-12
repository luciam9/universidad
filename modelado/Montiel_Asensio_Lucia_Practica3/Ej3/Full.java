package Ej3;

public class Full extends Estado{

    @Override
    public void put(Pieza pieza, Bandeja bandeja) {

        throw new RuntimeException("No se puede incliur una nueva pieza en una bandeja llena");
    }

    @Override
    public Pieza get(Bandeja bandeja) {
        Pieza p = bandeja.getPiezas().get(0);

        if(bandeja.size() > 1){

            bandeja.setEstado(new Normal());
        }else{

            bandeja.setEstado(new Empty());
        }
        bandeja.getPiezas().remove(0);

        return p;
    }
}
