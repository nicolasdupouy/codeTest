package com.example.strings;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

public class StringsDemo extends Activity {

	private EditText name;
	private TextView result;
	//private String format;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strings_demo);
        
        name = (EditText)findViewById(R.id.name);
    	result = (TextView)findViewById(R.id.result);
    	//format = getString(R.string.funky_format);
    }
    
    public void applyFormat(View v) {
    	String simpleResult = String.format(getString(R.string.funky_format) /*format*/, 
    										TextUtils.htmlEncode(name.getText().toString()));
    	result.setText(Html.fromHtml(simpleResult));
    }

}
