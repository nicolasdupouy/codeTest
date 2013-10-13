package com.example.flipper2;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;
import android.app.Activity;

public class FlipperDemo2 extends Activity {

	static String[] items = {"un", "dos", "tres", "quatro", "cinquo", "seis",
							 "siete", "ocho", "nueve", "diez"};
	ViewFlipper flipper;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        flipper = (ViewFlipper)findViewById(R.id.details);
        
        for (String item : items) {
        	Button btn = new Button(this);
        	btn.setText(item);
        	flipper.addView(btn,
        					new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
        											   ViewGroup.LayoutParams.FILL_PARENT));
        	flipper.setFlipInterval(2000);
        	flipper.startFlipping();
        }
    }
}
