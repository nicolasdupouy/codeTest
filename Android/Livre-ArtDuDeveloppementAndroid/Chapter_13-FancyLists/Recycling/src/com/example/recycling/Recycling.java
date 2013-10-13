package com.example.recycling;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Recycling extends ListActivity {

	private TextView selection;
	private static final String[] items={"lorem", "ipsum", "dolor",
					"sit", "amet",
					"consectetuer", "adipiscing", "elit", "morbi", "vel",
					"ligula", "vitae", "arcu", "aliquet", "mollis",
					"etiam", "vel", "erat", "placerat", "ante",
					"porttitor", "sodales", "pellentesque", "augue", "purus"};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setListAdapter(new IconicAdapter(this));
        selection = (TextView)findViewById(R.id.selection);
    }

    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		selection.setText(items[position]);
	}




	class IconicAdapter extends ArrayAdapter<String> {

    	public IconicAdapter(Activity context) {
    		super(context, R.layout.row, items);
    	}

    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) {

    		View row = convertView;
    		if (row == null)
    		{
    			LayoutInflater inflater = getLayoutInflater();
        		row = inflater.inflate(R.layout.row, parent, false);
    		}
    		
    		TextView label = (TextView)row.findViewById(R.id.label); 
    		label.setText(items[position]);
    		ImageView icon = (ImageView)row.findViewById(R.id.icon);
    		
    		if (items[position].length() > 4)
    		{
    			icon.setImageResource(R.drawable.delete);
    		}
    		else
    		{
    			icon.setImageResource(R.drawable.ok);
    		}
    		
    		
    		return row;
    	}


    }
}