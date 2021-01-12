package Ej1;

import java.util.*;

public class Paciente {

    private Expediente expedienteAbierto;
    private List<Expediente> expedientes;

    public Paciente() {

        expedienteAbierto = new Expediente();
        expedientes = new ArrayList<>();
    }

    public void addExpediente(Expediente e) {

        expedientes.add(e);
    }

    public Expediente getExpedienteAbierto() {
        return expedienteAbierto;
    }

    public void setExpedienteAbierto(Expediente expedienteAbierto) {
        if (expedientes.contains(expedienteAbierto)) {
            this.expedienteAbierto = expedienteAbierto;
        } else {
            throw new RuntimeException("El expediente no pertenece al paciente");

        }
    }
}