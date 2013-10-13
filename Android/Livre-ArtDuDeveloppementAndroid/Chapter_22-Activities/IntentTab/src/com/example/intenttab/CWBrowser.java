package com.example.intenttab;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class CWBrowser extends Activity {

	public static final String URL = "com.commonsware.android.intenttab.URL";
	private WebView browser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		browser = new WebView(this);
		setContentView(browser);
		browser.loadUrl(getIntent().getStringExtra(URL));
	}
	
	
}
