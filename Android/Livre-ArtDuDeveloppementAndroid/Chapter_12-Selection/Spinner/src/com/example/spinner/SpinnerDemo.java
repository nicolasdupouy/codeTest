package com.example.spinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerDemo extends Activity implements AdapterView.OnItemSelectedListener {

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
        selection=(TextView)findViewById(R.id.selection);
        
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
        													items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    */
    
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		selection.setText(items[arg2]);
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		selection.setText("");
	}
}
