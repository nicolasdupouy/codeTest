package com.example.autocomplete;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoComplete extends Activity implements TextWatcher {

	private TextView selection;
	private AutoCompleteTextView edit;
	
	private static final String[] items={"lorem", "ipsum", "dolor",
		"sit", "amet",
		"consectetuer", "adipiscing", "elit", "morbi", "vel",
		"ligula", "vitae", "arcu", "aliquet", "mollis",
		"etiam", "vel", "erat", "placerat", "ante",
		"porttitor", "sodales", "pellentesque", "augue", "purus"};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        selection = (TextView)findViewById(R.id.selection);
        edit=(AutoCompleteTextView)findViewById(R.id.edit);
        edit.addTextChangedListener(this);
        edit.setAdapter(new ArrayAdapter<String>(this, 
        										 android.R.layout.simple_dropdown_item_1line,
        										 items));
			
    }

	public void afterTextChanged(Editable s) {
		// N/A
	}

	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// N/A
	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		selection.setText(edit.getText());
	}
}
