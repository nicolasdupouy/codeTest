package com.nicolas.intentsavecretour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentExemple extends Activity {

	private Button mButton1 = null;
	private Button mButton2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_exemple);

		mButton1 = (Button)findViewById(R.id.button1);
		mButton1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.putExtra(MainActivity.BUTTONS, "1");
				setResult(RESULT_OK, i);
				finish();
			}
		});
		
		mButton2 = (Button)findViewById(R.id.button2);
		mButton2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.putExtra(MainActivity.BUTTONS, "2");
				setResult(RESULT_OK, i);
				finish();
			}
		});
		
	}
}
