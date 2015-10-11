package com.ecaresoft.cumulus.models;

import android.content.*;

import com.ecaresoft.cumulus.components.AbstractServiceModel;
import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MInterventions extends AbstractServiceModel {
    private String evento;
    private String fecha;
    private String codigo;
    private String nombre;

    public MInterventions(){}

    public static String INTERVENTIONS_SECTION = "intervenciones";

    @Override
    protected String sectionName() {
        return INTERVENTIONS_SECTION;
    }

    public static List<MInterventions> getInterventions(android.content.Context ctx){
        List<MInterventions> intervenciones = null;

        try{
            //Obtener Json del usuario
            int userID = DataBaseHelper.getSession(ctx);
            String json = DataBaseHelper.getSection(ctx, userID, INTERVENTIONS_SECTION);

            //Parsear Json a Objeto
            final Type tipo = new TypeToken<List<MInterventions>>(){}.getType();
            Gson gson = new Gson();
            intervenciones = gson.fromJson(json, tipo);
        } catch (Exception e){}

        //Retornar List<Object>
        return intervenciones;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEvento() {
        return evento;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }
}