package Ej3;

import java.util.*;

public class Bandeja {

    private int capacidad;
    private List<Pieza> piezas;
    private Estado estado;

    public Bandeja (int capacidad){

        if(capacidad < 1){

            throw new RuntimeException("Una bandeja debe tener capacidad 1 o más");
        }else{

            this.capacidad = capacidad;
        }

        this.piezas = new ArrayList<>();
        this.estado = new Empty();
    }

    public void put(Pieza pieza){

        estado.put(pieza, this);
    }

    public Pieza get(){

        return estado.get(this);
    }

    public int size() {
        return capacidad;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public List<Pieza> getPiezas() {
        return piezas;
    }

}
