package com.ecaresoft.cumulus.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.components.AbstractEMRSection;
import com.ecaresoft.cumulus.components.ItemsViewHolder;
import com.ecaresoft.cumulus.models.MEvent;

import java.util.List;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class FAppointment extends AbstractEMRSection<MEvent> {

    @Override
    public List<MEvent> getResult() {
        return MEvent.getEvents(getContext());
    }

    @Override
    public void render(ItemsViewHolder item, int index, MEvent object) {
        ((TextView)(item.findViewById(R.id.eventsName))).setText(object.getMotivo());
    }

    @Override
    public int getCardLayoutID() {
        return R.layout.events_card;
    }
}
