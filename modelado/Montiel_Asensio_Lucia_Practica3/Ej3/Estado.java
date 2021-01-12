package Ej3;

public abstract class Estado {

    public abstract void put(Pieza pieza, Bandeja bandeja);
    public abstract Pieza get(Bandeja bandeja);
}
