package com.ecaresoft.cumulus.models;

import com.ecaresoft.cumulus.components.AbstractServiceModel;
import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class MHistory extends AbstractServiceModel {
    private String clinica;
    private String personal;
    private String familiar;

    public MHistory(){}

    public static String HISTORY_SECTION = "alergias";

    @Override
    protected String sectionName() {
        return HISTORY_SECTION;
    }

    public static List<MHistory> getHistory(android.content.Context ctx){
        List<MHistory> historia = null;

        try{
            //Obtener Json del usuario
            int userID = DataBaseHelper.getSession(ctx);
            String json = DataBaseHelper.getSection(ctx, userID, HISTORY_SECTION);

            //Parsear Json a Objeto
            final Type tipo = new TypeToken<List<MHistory>>(){}.getType();
            Gson gson = new Gson();
            historia = gson.fromJson(json, tipo);
        } catch (Exception e){}

        //Retornar List<Object>
        return historia;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getClinica() {
        return clinica;
    }

    public String getFamiliar() {
        return familiar;
    }

    public String getPersonal() {
        return personal;
    }
}