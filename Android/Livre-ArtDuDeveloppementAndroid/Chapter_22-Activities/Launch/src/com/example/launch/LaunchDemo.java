package com.example.launch;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

public class LaunchDemo extends Activity {

	private EditText latitude;
	private EditText longitude;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        latitude = (EditText)findViewById(R.id.latitude);
        longitude = (EditText)findViewById(R.id.longitude);
    }
    
    public void showMe(View v) {
    	String _latitude = latitude.getText().toString();
    	String _longitude = longitude.getText().toString();
    	Uri uri = Uri.parse("geo:" +_latitude + "," + _longitude);
    	
    	startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

}
