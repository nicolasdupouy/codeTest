package com.example.dynamicdemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class IconicAdapter extends ArrayAdapter<String> {

	private String[] items;
	
	public IconicAdapter(DynamicDemo mainActivity, String[] items) {
		super(mainActivity, R.layout.row, R.id.label, items);
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View row = super.getView(position, convertView, parent);
		ImageView icon = (ImageView)row.findViewById(R.id.icon);
		if (items[position].length() == 4)
		{
			icon.setImageResource(R.drawable.delete);
		}
		/*
		else
		{
			icon.setImageResource(R.drawable.ok);
		}*/
		
		return row;
	}
	
	
}