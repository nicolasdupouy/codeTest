package com.example.bouttongrossissant;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnTouchListener {

	Button bouton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = (Button)findViewById(R.id.bouton);
        bouton.setOnTouchListener(this);
    }
//
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		bouton.setTextSize(Math.abs(event.getX() - bouton.getWidth()/2)
						 + Math.abs(event.getY() - bouton.getHeight()/2));
		return true;
	}

}
