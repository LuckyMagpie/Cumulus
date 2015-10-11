package com.ecaresoft.cumulus.components;

import android.content.Context;

import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;
import com.ecaresoft.cumulus.helpers.server.JSONRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by erodriguez on 11/10/2015.
 */
public abstract class AbstractServiceModel {

    protected abstract String sectionName();

    public void reload(Context ctx, int userID){
        SectionAsyncTask task = new SectionAsyncTask(ctx, userID, sectionName());
    }
}
