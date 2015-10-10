package com.ecaresoft.cumulus.recycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ecaresoft.cumulus.R;
import java.util.List;
import com.ecaresoft.cumulus.models.Items;

/**
 * Created by juan on 19/07/15.
 */
public class RVAdapter  extends RecyclerView.Adapter<RVAdapter.ItemsViewHolder>{
    List<Items> items;

    public RVAdapter(List<Items> items){
        this.items=items;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemsadapter, viewGroup, false);
        ItemsViewHolder pvh = new ItemsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final ItemsViewHolder itemsViewHolder, int i) {
        itemsViewHolder.tvTitle.setText(items.get(i).getTitle());
        ((TextView)itemsViewHolder.itemView.findViewById(R.id.tvLink)).setText(items.get(i).getLink());
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

    public static class ItemsViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        ImageView imLink;
        TextView tvTitle;


        ItemsViewHolder(View itemView){
            super(itemView);

            cv=(CardView)itemView.findViewById(R.id.cv);
            imLink=(ImageView)itemView.findViewById(R.id.imvLink);
            tvTitle=(TextView)itemView.findViewById(R.id.tvTitle);
        }
    }

}
