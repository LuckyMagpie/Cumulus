package com.ecaresoft.cumulus.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Modelo de Medicos
 * Created by erodriguez on 09/10/2015.
 */
public class MPhysician {
    private String nombre;
    private String cedula;

    public MPhysician(){}

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
