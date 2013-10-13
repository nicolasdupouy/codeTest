package com.example.browser3;

import java.util.Date;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Activity;

public class BrowserDemo3 extends Activity {

	WebView browser;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        browser = (WebView)findViewById(R.id.webkit);
        browser.setWebViewClient(new CallBack());
        
        loadTime();
    }
    
    void loadTime() {
    	String page = "<html><body>"
    				+ "<a href=\"clock\">"
    				+ new Date().toString()
    				+ "</a>"
    				+ "</body></html>";
    	browser.loadData(page, "text/html", "UTF-8");
    }
    
    private class CallBack extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			loadTime();
			return true;
		}
    	
    }
}
