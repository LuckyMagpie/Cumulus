package com.ecaresoft.cumulus.components;

import android.content.Context;
import android.os.AsyncTask;

import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;
import com.ecaresoft.cumulus.helpers.server.JSONRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para actualizar la informacion en segundo plano usando hilos
 * Actualiza en base de datos
 */
public class SectionAsyncTask extends AsyncTask<String, Void, String> {

    public static String SERVER_URL = "http://192.168.0.4/pacientes/"; //"http://192.168.11.190:8000/pacientes/";

    public Context ctx;
    public int userID;
    public String section;

    public SectionAsyncTask(Context ctx, int userID, String section){
        this.userID = userID;
        this.ctx = ctx;
        this.section = section;
        this.execute(SERVER_URL + userID + "/" + section);
    }

    /**
     * Metodo que llama la consutlta del servidor en segundo plano
     * @param strings
     * @return
     */
    @Override
    protected String doInBackground(String... strings) {
        try {
            return JSONRequest.GET(strings[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Se ejecuta despues de resibir la información del servidor
     * Actualiza la base de datos con la información que recibio
     * @param result
     */
    @Override
    protected void onPostExecute(String result) {
        if(validateJson(result)){
            DataBaseHelper.setSection(ctx, userID, section, result);
        }
    }

    /**
     * Valida que el archivo recibido sea un Json
     * @param json
     * @return true si es Json o false en caso contrario
     */
    public boolean validateJson(String json){
        try {
            new JSONObject(json);
        } catch (JSONException e){
            try {
                new JSONArray(json);
            } catch (JSONException e1){
                return false;
            }
        }
        return true;
    }
}