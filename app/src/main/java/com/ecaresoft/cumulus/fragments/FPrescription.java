package com.ecaresoft.cumulus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.components.AbstractEMRSection;
import com.ecaresoft.cumulus.components.ItemsViewHolder;
import com.ecaresoft.cumulus.models.MPrescription;

import java.util.List;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class FPrescription extends AbstractEMRSection<MPrescription> {

    @Override
    public List<MPrescription> getResult() {
        return MPrescription.getPrescriptions(getContext());
    }

    @Override
    public void render(ItemsViewHolder item, int index, MPrescription object) {
        ((TextView)(item.findViewById(R.id.diagNombre))).setText(object.getEvento());
        ((TextView)(item.findViewById(R.id.diagReaccion))).setText(object.getNotas());
    }

    @Override
    public int getCardLayoutID() {
        return R.layout.allergy_card;
    }
}
