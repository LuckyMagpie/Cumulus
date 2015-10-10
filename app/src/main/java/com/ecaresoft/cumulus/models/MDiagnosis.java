package com.ecaresoft.cumulus.models;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MDiagnosis {
    private String evento;
    private String fecha;
    private String codigo;
    private String nombre;

    public MDiagnosis(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEvento() {
        return evento;
    }
}