package Ej1;

import java.util.*;

public class Acceso {

    private Profesional profesional;
    private Expediente expediente;
    private Date fecha;
    private TipoAcceso tipo;

    public Acceso (Profesional p, Expediente e, Date f, TipoAcceso a){

        fecha = f;
        profesional = p;
        expediente = e;
        tipo = a;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoAcceso getTipo() {
        return tipo;
    }

    public void setTipo(TipoAcceso tipo) {
        this.tipo = tipo;
    }
}
