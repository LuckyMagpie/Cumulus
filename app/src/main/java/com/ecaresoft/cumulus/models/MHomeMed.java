package com.ecaresoft.cumulus.models;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MHomeMed {
    private String codigo;
    private String nombre;
    private String dosis;
    private String indicacion;
    private String via;

    public MHomeMed(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDosis() {
        return dosis;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public String getVia() {
        return via;
    }
}