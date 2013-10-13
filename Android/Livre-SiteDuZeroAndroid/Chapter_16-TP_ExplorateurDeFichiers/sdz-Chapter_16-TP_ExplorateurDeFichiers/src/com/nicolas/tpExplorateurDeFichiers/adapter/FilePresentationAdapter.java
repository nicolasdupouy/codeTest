package com.nicolas.tpExplorateurDeFichiers.adapter;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FilePresentationAdapter extends ArrayAdapter<File> {

	private LayoutInflater layoutInflater = null;
	private int textViewResourceId = 0;
	private int color = 0;
	
	public FilePresentationAdapter(Context context, int textViewResourceId,
			List<File> objects, int color) {
		super(context, textViewResourceId, objects);
		layoutInflater = LayoutInflater.from(context);
		this.textViewResourceId = textViewResourceId;
		this.color = color;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		TextView view = null;
		if (convertView != null) {
			view = (TextView)convertView;
		}
		else {
			view = (TextView)layoutInflater.inflate(this.textViewResourceId /*android.R.layout.simple_list_item_1*/, null);
		}

		File itemFile = getItem(position);

		if (itemFile.isDirectory()) {
			view.setTextColor(color);
		}
		else {
			view.setTextColor(Color.BLACK);
		}
		
		view.setText(itemFile.getName());
		return view;
		//return super.getView(position, convertView, parent);
	}


	public void sort() {
		super.sort(new FileComparator());
	}
}
