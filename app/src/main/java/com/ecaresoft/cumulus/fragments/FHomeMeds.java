package com.ecaresoft.cumulus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.components.AbstractEMRSection;
import com.ecaresoft.cumulus.components.ItemsViewHolder;
import com.ecaresoft.cumulus.models.MHomeMed;

import java.util.List;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class FHomeMeds extends AbstractEMRSection<MHomeMed> {
    @Override
    public int getRecyclerViewID() {
        return 0;
    }

    @Override
    public int getSectionViewID() {
        return R.layout.medicamentos;
    }

    @Override
    public List<MHomeMed> getResult() {
        return MHomeMed.getMedications(getContext());
    }

    @Override
    public void render(ItemsViewHolder item, int index, MHomeMed object) {

    }

    @Override
    public int getCardLayoutID() {
        return 0;
    }
}
