package com.ecaresoft.cumulus.models;


import android.content.Context;

import com.ecaresoft.cumulus.components.AbstractServiceModel;
import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;
import com.ecaresoft.cumulus.helpers.server.JSONRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MDiagnosis extends AbstractServiceModel {
    private String evento;
    private String fecha;
    private String codigo;
    private String nombre;
    private String paciente;
    private String id;

    public MDiagnosis(){}

    public static String DIAGNOSIS_SECTION = "diagnosticos";

    @Override
    protected String sectionName() {
        return DIAGNOSIS_SECTION;
    }

    public static List<MDiagnosis> getDiagnosis(Context ctx){
        List<MDiagnosis> diagnosticos = null;

        try{
            //Obtener Json del usuario
            int userID = DataBaseHelper.getSession(ctx);
            String json = DataBaseHelper.getSection(ctx, userID, DIAGNOSIS_SECTION);

            //Parsear Json a Objeto
            final Type tipo = new TypeToken<List<MDiagnosis>>(){}.getType();
            Gson gson = new Gson();
            diagnosticos = gson.fromJson(json, tipo);
        } catch (Exception e){}

        //Retornar List<Object>
        return diagnosticos;
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getPaciente() {
        return paciente;
    }
}