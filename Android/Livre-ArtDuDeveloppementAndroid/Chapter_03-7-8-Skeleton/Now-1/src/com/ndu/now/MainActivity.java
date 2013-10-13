package com.ndu.now;

import java.util.Date;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

	Button btn;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        btn = new Button(this);
        btn.setOnClickListener(this);
        updateTime();
        setContentView(btn);
        //setContentView(R.layout.activity_main);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/

    public void onClick(View v) {
		updateTime();
	}
    
    private void updateTime() {
    	btn.setText(new Date().toString());
    }

}
