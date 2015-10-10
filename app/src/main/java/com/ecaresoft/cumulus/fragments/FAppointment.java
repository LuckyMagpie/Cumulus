package com.ecaresoft.cumulus.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.models.MEvent;

import java.util.List;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class FAppointment extends Fragment {

    List<MEvent> events;

    public FAppointment(List<MEvent> evt){
        super();
        events = evt;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.citas,container,false);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        return rootView;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }
}
