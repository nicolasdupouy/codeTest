package com.example.dynamicdemo;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class DynamicDemo extends ListActivity {

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
        setListAdapter(new IconicAdapter(DynamicDemo.this, items));
        selection = (TextView)findViewById(R.id.selection);
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		selection.setText(items[position]);
	}
}