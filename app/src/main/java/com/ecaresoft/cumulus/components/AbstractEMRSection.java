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
public abstract class AbstractEMRSection<T extends Object> extends Fragment {
    RecyclerView rv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(getSectionViewID(),container,false);
        setHasOptionsMenu(true);
        setRetainInstance(true);

        getCard(rootView);


        return rootView;
    }

    private void getCard(View rootView){
        rv=(RecyclerView)rootView.findViewById(getRecyclerViewID());
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        rv.setLayoutManager(llm);
        EMRAdapter adapter = new EMRAdapter(this, getResult());
        rv.setAdapter(adapter);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    public abstract int getRecyclerViewID();

    public abstract int getSectionViewID();

    public abstract List<T> getResult();

    public abstract void render(ItemsViewHolder item, int index, T object);

    public abstract int getCardLayoutID();
}
