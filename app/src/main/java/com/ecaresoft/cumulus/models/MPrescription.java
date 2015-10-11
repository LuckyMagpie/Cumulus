package com.ecaresoft.cumulus.models;

import android.content.Context;

import com.ecaresoft.cumulus.components.AbstractServiceModel;
import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MPrescription extends AbstractServiceModel {
    private String fecha;
    private String evento;
    private List<MPrescDetail> detalles;
    private String notas;

    public MPrescription(){}

    public static String PRESCRIPTION_SECTION = "diagnosticos";

    @Override
    protected String sectionName() {
        return PRESCRIPTION_SECTION;
    }

    public static List<MPrescription> getPrescriptions(Context ctx){
        List<MPrescription> prescripciones = null;

        try{
            //Obtener Json del usuario
            int userID = DataBaseHelper.getSession(ctx);
            String json = DataBaseHelper.getSection(ctx, userID, PRESCRIPTION_SECTION);

            //Parsear Json a Objeto
            final Type tipo = new TypeToken<List<MPrescription>>(){}.getType();
            Gson gson = new Gson();
            prescripciones = gson.fromJson(json, tipo);
        } catch (Exception e){}

        //Retornar List<Object>
        return prescripciones;
    }

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



