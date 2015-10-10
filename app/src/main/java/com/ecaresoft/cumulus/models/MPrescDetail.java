package com.ecaresoft.cumulus.models;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MPrescDetail {
    private String codigo;
    private String nombre;
    private String dosis;
    private String indicacion;
    private String via;

    public MPrescDetail(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getDosis() {
        return dosis;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getVia() {
        return via;
    }
}
