package com.example.ratelistdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateListDemo extends ListActivity {

	private static final String[] items={"lorem", "ipsum", "dolor",
		"sit", "amet",
		"consectetuer", "adipiscing", "elit", "morbi", "vel",
		"ligula", "vitae", "arcu", "aliquet", "mollis",
		"etiam", "vel", "erat", "placerat", "ante",
		"porttitor", "sodales", "pellentesque", "augue", "purus"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_rate_list_demo);

		ArrayList<RowModel> list = new ArrayList<RowModel>();

		for (String s : items) {
			list.add(new RowModel(s));
		}

		setListAdapter(new RatingAdapter(list));
	}

	private RowModel getModel(int position) {
		return(((RatingAdapter)getListAdapter()).getItem(position));
	}    






	class RatingAdapter extends ArrayAdapter<RowModel> {

		public RatingAdapter(ArrayList<RowModel> list) {
			super(RateListDemo.this, R.layout.row, R.id.label, list);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = super.getView(position, convertView, parent);

			ViewHolder holder = (ViewHolder)row.getTag();
			if (holder==null) {													
				holder=new ViewHolder(row);
				row.setTag(holder);

				RatingBar.OnRatingBarChangeListener l = new RatingBar.OnRatingBarChangeListener() {

					public void onRatingChanged(RatingBar ratingBar, 
							float rating, 
							boolean fromUser) {
						Integer myPosition = (Integer)ratingBar.getTag();
						RowModel model = getModel(myPosition);
						model.rating = rating;

						LinearLayout parent = (LinearLayout)ratingBar.getParent();
						TextView label = (TextView)parent.findViewById(R.id.label);
						label.setText(model.toString());
					}
				};

				holder.rate.setOnRatingBarChangeListener(l);
			}

			RowModel model = getModel(position);
			holder.rate.setTag(Integer.valueOf(position));
			holder.rate.setRating(model.rating);

			return row;
		}
	}
}
