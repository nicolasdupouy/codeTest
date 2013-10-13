package com.example.viewholder;

import android.view.View;
import android.widget.ImageView;

public class ViewHolder {
	ImageView icon = null;
	
	public ViewHolder(View base) {
		this.icon = (ImageView)base.findViewById(R.id.icon);
	}
}
