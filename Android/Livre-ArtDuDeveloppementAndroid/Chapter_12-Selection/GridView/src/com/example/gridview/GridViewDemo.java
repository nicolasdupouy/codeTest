package com.example.gridview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class GridViewDemo extends Activity implements AdapterView.OnItemSelectedListener {

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
        
        selection = (TextView)findViewById(R.id.selection);
        
        GridView g = (GridView)findViewById(R.id.gridView);
        g.setAdapter(new ArrayAdapter<String>(this, R.layout.cell, items));
        g.setOnItemSelectedListener(this);
    }

    
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		selection.setText(items[arg2]);
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		selection.setText("");
	}

   
}
