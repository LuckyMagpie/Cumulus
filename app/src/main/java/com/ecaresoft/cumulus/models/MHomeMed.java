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
public class MHomeMed extends AbstractServiceModel {
    private String codigo;
    private String nombre;
    private String dosis;
    private String indicacion;
    private String via;

    public MHomeMed(){}

    public static String HOME_MEDICATION_SECTION = "medicamentos";

    @Override
    protected String sectionName() {
        return HOME_MEDICATION_SECTION;
    }

    public static List<MHomeMed> getMedications(android.content.Context ctx){
        List<MHomeMed> medicamentos = null;

        try{
            //Obtener Json del usuario
            int userID = DataBaseHelper.getSession(ctx);
            String json = DataBaseHelper.getSection(ctx, userID, HOME_MEDICATION_SECTION);

            //Parsear Json a Objeto
            final Type tipo = new TypeToken<List<MHomeMed>>(){}.getType();
            Gson gson = new Gson();
            medicamentos = gson.fromJson(json, tipo);
        } catch (Exception e){}

        //Retornar List<Object>
        return medicamentos;
    }

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