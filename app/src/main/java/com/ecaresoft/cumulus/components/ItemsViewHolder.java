package com.ecaresoft.cumulus.components;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ecaresoft.cumulus.R;

/**
 * Created by erodriguez on 10/10/2015.
 */
public class ItemsViewHolder extends RecyclerView.ViewHolder{

    public ItemsViewHolder(View itemView){
        super(itemView);
    }

    public View findViewById(int id){
        return itemView.findViewById(id);
    }
}
