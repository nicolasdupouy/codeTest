package com.example.flipper1;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;
import android.app.Activity;

public class FlipperDemo extends Activity {

	ViewFlipper viewFlipper;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        viewFlipper = (ViewFlipper)findViewById(R.id.details);
    }
    
    public void flip(View view) {
    	viewFlipper.showNext();
    }
}
