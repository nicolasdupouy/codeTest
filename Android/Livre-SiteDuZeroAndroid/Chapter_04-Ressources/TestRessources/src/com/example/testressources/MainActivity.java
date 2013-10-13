package com.example.testressources;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {

	TextView text;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Resources resource = getResources();
        String helloWorld = getResources().getString(R.string.hello_world);
        text = new TextView(this);
        text.setText(helloWorld /*0x7f050000*/ /*R.string.hello_world*/);
        
        setContentView(text);
        //setContentView(R.layout.activity_main);
    }

}
