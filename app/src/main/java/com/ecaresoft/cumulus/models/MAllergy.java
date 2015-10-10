package com.ecaresoft.cumulus.models;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MAllergy {
    private String tipo;
    private String nombre;
    private String reaccion;
    private String severidad;

    public MAllergy(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setReaccion(String reaccion) {
        this.reaccion = reaccion;
    }

    public String getReaccion() {
        return reaccion;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }

    public String getSeveridad() {
        return severidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}