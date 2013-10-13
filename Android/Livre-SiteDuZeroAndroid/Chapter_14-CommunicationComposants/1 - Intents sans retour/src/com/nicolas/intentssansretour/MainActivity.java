package com.nicolas.intentssansretour;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	public static final String AGE = "com.nicolas.intent.exemple1.AGE";
	private Button mPasserelle = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mPasserelle = (Button)findViewById(R.id.passerelle);
        mPasserelle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent secondActivity = new Intent(MainActivity.this, IntentExemple.class);
				secondActivity.putExtra(AGE, 31);
				
				startActivity(secondActivity);
			}
		});
    }

}
