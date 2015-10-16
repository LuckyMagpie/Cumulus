package com.ecaresoft.cumulus.components;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by erodriguez on 10/10/2015.
 */
public class EMRAdapter extends RecyclerView.Adapter<ItemsViewHolder> {
    protected List<? extends Object> items;
    protected AbstractEMRSection parent;

    public EMRAdapter(AbstractEMRSection parent, List<? extends Object> items){
        this.items = items;
        this.parent = parent;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(getViewID(), viewGroup, false);
        ItemsViewHolder pvh = new ItemsViewHolder(v);
        return pvh;
    }

    @Override
    public int getItemCount() {
        try {
            return items.size();
        }catch(Exception ex){}
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(final ItemsViewHolder itemsViewHolder, int i) {
        parent.render(itemsViewHolder, i, items.get(i));
    }

    public int getViewID() {
        return parent.getCardLayoutID();
    }

}
