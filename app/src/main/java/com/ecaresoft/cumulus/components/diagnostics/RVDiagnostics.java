package com.ecaresoft.cumulus.components.diagnostics;

import android.widget.TextView;

import com.ecaresoft.cumulus.components.AbstractAdapter;
import com.ecaresoft.cumulus.components.ItemsViewHolder;
import com.ecaresoft.cumulus.models.MDiagnosis;

import java.util.List;
import com.ecaresoft.cumulus.R;

/**
 * Created by erodriguez on 09/10/2015.
 */
public class RVDiagnostics  extends AbstractAdapter {

    public RVDiagnostics(List<MDiagnosis> items){
        super(items);
    }

    @Override
    public void onBindViewHolder(final ItemsViewHolder itemsViewHolder, int i) {
        MDiagnosis diag = (MDiagnosis)(items.get(i));
        ((TextView)(itemsViewHolder.findViewById(R.id.tvLink))).setText(diag.getNombre());
    }

    @Override
    public int getViewID() {
        return R.layout.diagnosis_card;
    }
}
