package com.example.application;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity {

	Button button;
	String histoire;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        histoire = getResources().getString(R.string.histoire);
        Spanned histoireSpannedHTML = Html.fromHtml(histoire);
        
        button = new Button(this);
        button.setText(histoireSpannedHTML);
        
        setContentView(button);
    }
    
}
