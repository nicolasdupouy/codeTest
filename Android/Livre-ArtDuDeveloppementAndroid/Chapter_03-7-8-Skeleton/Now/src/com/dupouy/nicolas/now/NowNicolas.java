package com.dupouy.nicolas.now;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class NowNicolas extends Activity implements View.OnClickListener {

	Button button;
	boolean switchButtonText = false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_now_nicolas);
        
        /*button = new Button(this);
        button.setOnClickListener(this);
        updateTime();
        setContentView(button);*/
        
        setContentView(R.layout.main);
        
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        //updateTime();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_now_nicolas, menu);
        return true;
    }*/
    
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
