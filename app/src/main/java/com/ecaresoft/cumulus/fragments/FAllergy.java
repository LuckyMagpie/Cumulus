package com.ecaresoft.cumulus.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.components.AbstractAdapter;
import com.ecaresoft.cumulus.components.AbstractFragment;
import com.ecaresoft.cumulus.components.diagnostics.RVDiagnostics;
import com.ecaresoft.cumulus.models.MDiagnosis;


/**
 * Created by juanortizjr on 9/10/15.
 */
public class FAllergy extends AbstractFragment {

    @Override
    public AbstractAdapter getAdapter() {
        return new RVDiagnostics(null);
    }

    @Override
    public int getRecyclerViewID() {
        return R.id.rvaler;
    }

    @Override
    public int getViewID() {
        return R.layout.alergias;
    }
}
