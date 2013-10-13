package com.example.message;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MessageDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void showAlert(View view) {
    	new AlertDialog.Builder(this)
    		.setTitle("MessageDemo")
    		.setMessage("Levons un Toast !")
    		.setNeutralButton("Ici, ici !", new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MessageDemo.this,
									"<Clac, Clac>", 
									Toast.LENGTH_SHORT)
						 .show();
				}
			})
			.show();
    }
}
