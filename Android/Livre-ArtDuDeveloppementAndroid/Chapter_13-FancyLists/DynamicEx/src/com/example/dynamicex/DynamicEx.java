package com.example.dynamicex;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DynamicEx extends ListActivity {

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
        setContentView(R.layout.mon_main);
        setListAdapter(new IconicAdapter());
        selection = (TextView)findViewById(R.id.selection);
    }

    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		selection.setText(items[position]);
	}




	class IconicAdapter extends ArrayAdapter<String> {

    	public IconicAdapter() {
    		super(DynamicEx.this, R.layout.row, R.id.label, items);
    	}

    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) {

    		LayoutInflater inflater = getLayoutInflater();
    		View row = inflater.inflate(R.layout.row, parent, false);
    		//View row = LayoutInflater.from(getBaseContext()).inflate(R.layout.row, parent, false); //super.getView(position, convertView, parent);
    		TextView label = (TextView)row.findViewById(R.id.label); 
    		
    		label.setText(items[position]);
    		//View row = super.getView(position, convertView, parent);
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