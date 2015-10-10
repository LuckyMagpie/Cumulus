package com.ecaresoft.cumulus.fragments;

import android.view.View;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.components.AbstractAdapter;
import com.ecaresoft.cumulus.components.AbstractFragment;
import com.ecaresoft.cumulus.components.diagnostics.RVDiagnostics;
import com.ecaresoft.cumulus.models.MDiagnosis;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class FDiagnostic extends AbstractFragment {

    @Override
    public AbstractAdapter getAdapter() {
        return new RVDiagnostics(MDiagnosis.getMDiagnosis());
    }

    @Override
    public int getRecyclerViewID() {
        return R.id.rvdiag;
    }

    @Override
    public int getViewID() {
        return R.layout.diagnosticos;
    }
}
