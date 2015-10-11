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
public class MVitalSign extends AbstractServiceModel {
    private String fecha;
    private String evento;
    private List<MVSign> signo;

    public MVitalSign(){}

    public static String VITAL_SIGN_SECTION = "tomas_signos";

    @Override
    protected String sectionName() {
        return VITAL_SIGN_SECTION;
    }

    public static List<MVitalSign> getRevisions(android.content.Context ctx){
        List<MVitalSign> signos = null;

        try{
            //Obtener Json del usuario
            int userID = DataBaseHelper.getSession(ctx);
            String json = DataBaseHelper.getSection(ctx, userID, VITAL_SIGN_SECTION);

            //Parsear Json a Objeto
            final Type tipo = new TypeToken<List<MVitalSign>>(){}.getType();
            Gson gson = new Gson();
            signos = gson.fromJson(json, tipo);
        } catch (Exception e){}

        //Retornar List<Object>
        return signos;
    }
}