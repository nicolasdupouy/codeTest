package com.nicolas.intentsavecretour;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	public static final String BUTTONS = "com.nicolas.intent.exemple.boutons";
	public static final int CHOOSE_BUTTON_REQUEST = 0;
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
				
				startActivityForResult(secondActivity, CHOOSE_BUTTON_REQUEST);
			}
		});
        
        
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == CHOOSE_BUTTON_REQUEST
				&& resultCode == RESULT_OK) {
			Toast.makeText(this, 
							"Vous avez choisit le bouton n°" + data.getStringExtra(BUTTONS), 
							Toast.LENGTH_SHORT)
							.show();
		}
	}
}
