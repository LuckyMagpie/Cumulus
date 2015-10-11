package com.ecaresoft.cumulus.fragments;

import android.widget.TextView;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.components.EMRAdapter;
import com.ecaresoft.cumulus.components.AbstractEMRSection;
import com.ecaresoft.cumulus.components.ItemsViewHolder;
import com.ecaresoft.cumulus.models.MAllergy;
import com.ecaresoft.cumulus.models.MDiagnosis;

import java.util.List;


/**
 * Created by juanortizjr on 9/10/15.
 */
public class FAllergy extends AbstractEMRSection<MAllergy> {

    @Override
    public int getRecyclerViewID() {
        return R.id.rvaler;
    }

    @Override
    public int getSectionViewID() {
        return R.layout.alergias;
    }

    @Override
    public int getCardLayoutID() {
        return R.layout.allergy_card;
    }

    @Override
    public List<MAllergy> getResult() {
        return MAllergy.getAllergies(getContext());
    }

    @Override
    public void render(ItemsViewHolder item, int index, MAllergy object) {
        ((TextView)(item.findViewById(R.id.diagNombre))).setText(object.getNombre());
        ((TextView)(item.findViewById(R.id.diagReaccion))).setText(object.getReaccion());
        ((TextView)(item.findViewById(R.id.diagTipo))).setText(object.getTipo());
        ((TextView)(item.findViewById(R.id.diagSeveridad))).setText(object.getSeveridad());
    }
}
