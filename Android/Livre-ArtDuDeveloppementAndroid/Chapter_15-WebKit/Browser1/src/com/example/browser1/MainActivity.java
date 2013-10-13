package com.example.browser1;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;

public class MainActivity extends Activity {

	WebView browser;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        browser = (WebView)findViewById(R.id.webkit);
        
        //browser.loadUrl("http://www.sc2replay.fr");
        browser.loadData("<html><body>Bonjour !</body></html>", "text/html", "UTF-8");
    }
}
