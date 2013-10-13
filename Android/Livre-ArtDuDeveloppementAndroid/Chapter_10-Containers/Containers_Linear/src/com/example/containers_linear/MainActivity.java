package com.example.containers_linear;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.widget.*;

//import android.view.Menu;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

	RadioGroup orientation;
	RadioGroup gravity;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.main);
        
        orientation=(RadioGroup)findViewById(R.id.orientation);
        orientation.setOnCheckedChangeListener(this);
        gravity=(RadioGroup)findViewById(R.id.gravity);
        gravity.setOnCheckedChangeListener(this);
    }

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId) {
			case R.id.horizontal:
				orientation.setOrientation(LinearLayout.HORIZONTAL);
				gravity.setOrientation(LinearLayout.HORIZONTAL);
				break;
			case R.id.vertical:
				orientation.setOrientation(LinearLayout.VERTICAL);
				gravity.setOrientation(LinearLayout.VERTICAL);
				break;
			case R.id.hanounti:
				gravity.setGravity(Gravity.LEFT);
				break;
			case R.id.est:
				gravity.setGravity(Gravity.CENTER_HORIZONTAL);
				break;
			case R.id.ma:
				gravity.setGravity(Gravity.CENTER_VERTICAL);
				break;
			case R.id.cherie:
				gravity.setGravity(Gravity.RIGHT);
				break;
		}
	}

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
}
