package com.ecaresoft.cumulus.models;

import android.content.*;

import com.ecaresoft.cumulus.components.AbstractServiceModel;
import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Cada uno de los eventos del pacitente (Consultas, Operaciones, etc)
 * Created by erodriguez on 09/10/2015.
 */
public class MEvent extends AbstractServiceModel {

    public String id;
    public String fecha;
    public MPhysician medico;
    public String especialidad;
    public String tipo;
    public String motivo;

    public MEvent(){}

    public static String EVENTS_SECTION = "eventos";

    @Override
    protected String sectionName() {
        return EVENTS_SECTION;
    }

    public static List<MEvent> getEvents(android.content.Context ctx){
        List<MEvent> eventos = null;

        try{
            //Obtener Json del usuario
            int userID = DataBaseHelper.getSession(ctx);
            String json = DataBaseHelper.getSection(ctx, userID, EVENTS_SECTION);

            if(json != null){
                //Parsear Json a Objeto
                final Type tipo = new TypeToken<List<MEvent>>(){}.getType();
                Gson gson = new Gson();
                eventos = gson.fromJson(json, tipo);
            }
        } catch (Exception e){}

        //Retornar List<Object>
        return eventos;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setMedico(MPhysician medico) {
        this.medico = medico;
    }

    public MPhysician getMedico() {
        return medico;
    }

}