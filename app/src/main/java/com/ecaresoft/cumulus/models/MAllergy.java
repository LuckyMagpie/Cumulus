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
public class MAllergy extends AbstractServiceModel {
    private String tipo;
    private String nombre;
    private String reaccion;
    private String severidad;

    public MAllergy(){}

    public static String ALLERGY_SECTION = "alergias";

    @Override
    protected String sectionName() {
        return ALLERGY_SECTION;
    }

    public static List<MAllergy> getAllergies(Context ctx){
        List<MAllergy> alergias = null;

        try{
            //Obtener Json del usuario
            int userID = DataBaseHelper.getSession(ctx);
            String json = DataBaseHelper.getSection(ctx, userID, ALLERGY_SECTION);

            //Parsear Json a Objeto
            final Type tipo = new TypeToken<List<MAllergy>>(){}.getType();
            Gson gson = new Gson();
            alergias = gson.fromJson(json, tipo);
        } catch (Exception e){}

        //Retornar List<Object>
        return alergias;
    }

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