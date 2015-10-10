package com.ecaresoft.cumulus.models;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MVSign {
    private String valor;
    private String nombre;
    private String unidad;

    public MVSign(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getValor() {
        return valor;
    }
}
