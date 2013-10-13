package com.example.checklist;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class CheckList extends ListActivity {

	private static final String[] items={"lorem", "ipsum", "dolor",
		"sit", "amet",
		"consectetuer", "adipiscing", "elit", "morbi", "vel",
		"ligula", "vitae", "arcu", "aliquet", "mollis",
		"etiam", "vel", "erat", "placerat", "ante",
		"porttitor", "sodales", "pellentesque", "augue", "purus"};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_checklist);
        setListAdapter(new ArrayAdapter<String>(this, 
        								   		android.R.layout.simple_list_item_multiple_choice,
        								   		items));
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
}
