package com.ecaresoft.cumulus.models;

import android.content.Context;
import com.ecaresoft.cumulus.components.AbstractServiceModel;

import java.math.MathContext;
import java.util.List;

/**
 * Modelo de Expediente Clinico Electronico
 * Created by erodriguez on 09/10/2015.
 */
public class MEMR {

    private Context ctx;
    private int userID;

    Object[] objLts = new Object[]{
            new MEvent(),
            new MPrescription(),
            new MAllergy(),
            new MDiagnosis(),
            new MInterventions(),
            new MHomeMed(),
            new MVitalSign(),
            new MHistory()
    };

    public MEMR(Context ctx, int userID){
        this.ctx = ctx;
        this.userID = userID;
    }

    public void updtate(){
        for (Object obj: objLts) {
            if(obj instanceof AbstractServiceModel){
                ((AbstractServiceModel)obj).reload(ctx, userID);
            }
        }
    }
}
