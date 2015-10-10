package com.ecaresoft.cumulus.models;

import java.util.List;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MPrescription {
    private String fecha;
    private String evento;
    private List<MPrescDetail> detalles;
    private String notas;

    public MPrescription(){}

    public void setDetalles(List<MPrescDetail> detalles) {
        this.detalles = detalles;
    }

    public List<MPrescDetail> getDetalles() {
        return detalles;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEvento() {
        return evento;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNotas() {
        return notas;
    }
}



