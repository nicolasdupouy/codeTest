package com.example.nowstyled;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class NowStyled extends Activity implements View.OnClickListener {

	Button button;
	boolean switchButtonText = false;
	
	@Override
	/**
	 * 
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_now_styled);
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(this);
	}
	
	
	public void onClick(View v) {
		updateTime();
	}
	

	 private void updateTime() {
	    	if (switchButtonText) 
	    	{
	    		button.setText(new Date().toString());
	    	}
	    	else 
	    	{
	    		button.setText(R.string.hello_world);
	    	}
	    	switchButtonText = !switchButtonText;
	    	//button.setText(new Date().toString());
	    }
}
