package adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ecaresoft.cumulus.R;

import models.Items;

public class SearchAdapter extends BaseAdapter {

	private Context context;
	private final List<Items> items;
	
	public SearchAdapter(Context context, List<Items> items){
		this.context = context;
		this.items = items;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RelativeLayout rowLayout;

		if(convertView == null) {
			rowLayout = (RelativeLayout)LayoutInflater.from(context).inflate(R.layout.itemsadapter, parent, false);
			Items item = (Items)getItem(position);
			
			TextView tvTitle = (TextView)rowLayout.findViewById(R.id.tvTitle);
			tvTitle.setText(item.getTitle());

			TextView tvLink = (TextView)rowLayout.findViewById(R.id.tvLink);
			tvLink.setText(item.getLink());

			convertView = rowLayout;
		}
		
		return convertView;
	}

}
