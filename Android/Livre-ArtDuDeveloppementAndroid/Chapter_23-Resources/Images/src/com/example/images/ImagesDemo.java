package com.example.images;


import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ImagesDemo extends Activity {

	private EditText name;
	private TextView result;
	//private String format;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_demo);
        
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
