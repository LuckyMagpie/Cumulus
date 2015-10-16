package com.ecaresoft.cumulus.fragments;

import android.widget.TextView;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.components.AbstractEMRSection;
import com.ecaresoft.cumulus.components.ItemsViewHolder;
import com.ecaresoft.cumulus.models.MDiagnosis;

import java.util.List;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class FDiagnostic extends AbstractEMRSection<MDiagnosis> {

    @Override
    public int getCardLayoutID() {
        return R.layout.diagnosis_card;
    }

    @Override
    public List<MDiagnosis> getResult(){
        return MDiagnosis.getDiagnosis(getContext());
    }

    @Override
    public void render(ItemsViewHolder item, int index, MDiagnosis object) {
        ((TextView)(item.findViewById(R.id.diagSeveridad))).setText(object.getNombre());
        ((TextView)(item.findViewById(R.id.diagFecha))).setText(object.getFecha());
    }
}
