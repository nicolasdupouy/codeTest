package com.example.intenttab;

import android.os.Bundle;
import android.widget.TabHost;
import android.app.TabActivity;
import android.content.Intent;

public class IntentTabDemo extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TabHost tabHost = getTabHost();
		Intent i = new Intent(this, CWBrowser.class);
		
		i.putExtra(CWBrowser.URL, "http://www.pearson.fr");
		tabHost.addTab(tabHost.newTabSpec("un")
				.setIndicator("Ppearson")
				.setContent(i));
		
		i = new Intent(i);
		i.putExtra(CWBrowser.URL, "http://www.android.com");
		tabHost.addTab(tabHost.newTabSpec("deux")
				.setIndicator("Android")
				.setContent(i));
	}

}
