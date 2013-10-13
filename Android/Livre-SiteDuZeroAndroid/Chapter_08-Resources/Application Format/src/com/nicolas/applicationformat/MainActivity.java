package com.nicolas.applicationformat;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {

	TextView vue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String hello = getResources().getString(R.string.hello, "Anaïs", 22);
		
		vue = (TextView)findViewById(R.id.vue);		
		vue.setText(hello);
	}

}
