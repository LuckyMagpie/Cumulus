package com.ecaresoft.cumulus.components.allergies;

import android.widget.TextView;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.components.AbstractAdapter;
import com.ecaresoft.cumulus.components.ItemsViewHolder;
import com.ecaresoft.cumulus.models.MAllergy;

import java.util.List;

/**
 * Created by erodriguez on 10/10/2015.
 */
public class RVAllergies extends AbstractAdapter {

    public RVAllergies(List<MAllergy> items){
        super(items);
    }

    @Override
    public void onBindViewHolder(final ItemsViewHolder itemsViewHolder, int i) {
        MAllergy alergy = (MAllergy)(items.get(i));
        ((TextView)(itemsViewHolder.findViewById(R.id.diagNombre))).setText(alergy.getNombre());
        ((TextView)(itemsViewHolder.findViewById(R.id.diagReaccion))).setText(alergy.getReaccion());
        ((TextView)(itemsViewHolder.findViewById(R.id.diagTipo))).setText(alergy.getTipo());
        ((TextView)(itemsViewHolder.findViewById(R.id.diagSeveridad))).setText(alergy.getSeveridad());
    }

    @Override
    public int getViewID() {
        return R.layout.allergy_card;
    }
}
