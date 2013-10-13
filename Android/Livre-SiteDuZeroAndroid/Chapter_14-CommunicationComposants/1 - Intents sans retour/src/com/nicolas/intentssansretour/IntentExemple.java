package com.nicolas.intentssansretour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class IntentExemple extends Activity {

	
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.layout_exemple);

		 Intent i = getIntent();
		 int age = i.getIntExtra(MainActivity.AGE, 0);
		 
		 Log.v("AGE", "age = " + String.valueOf(age));
	 }
}
