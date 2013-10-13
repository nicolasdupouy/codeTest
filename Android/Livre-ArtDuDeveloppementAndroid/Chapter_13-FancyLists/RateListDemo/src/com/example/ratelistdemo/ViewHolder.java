package com.example.ratelistdemo;

import android.view.View;
import android.widget.RatingBar;

public class ViewHolder {
	RatingBar rate = null;
	
	public ViewHolder(View base) {
		this.rate = (RatingBar)base.findViewById(R.id.rate);
	}
}
