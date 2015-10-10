package com.ecaresoft.cumulus.components;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecaresoft.cumulus.R;

import java.util.List;

/**
 * Created by erodriguez on 09/10/2015.
 */
public abstract class AbstractFragment extends Fragment {
    RecyclerView rv;
    List<Object> items;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(getViewID(),container,false);
        setHasOptionsMenu(true);
        setRetainInstance(true);

        getCard(rootView);


        return rootView;
    }

    public void getCard(View rootView){
        rv=(RecyclerView)rootView.findViewById(getRecyclerViewID());
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(llm);
        AbstractAdapter adapter = getAdapter();
        rv.setAdapter(adapter);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    public abstract int getRecyclerViewID();

    public abstract AbstractAdapter getAdapter();

    public abstract int getViewID();
}
