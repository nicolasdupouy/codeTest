package com.example.dynamictab;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TabHost;
import android.app.Activity;

public class DynamicTabDemo extends Activity {

	private TabHost tabs = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_tab_demo);
        
        tabs = (TabHost)findViewById(R.id.tabhost);
        tabs.setup();
        
        TabHost.TabSpec spec = tabs.newTabSpec("buttontab");
        spec.setContent(R.id.buttontab);
        spec.setIndicator("Bouton");
        tabs.addTab(spec);
    }
    
    public void addTab(View view) {
    	TabHost.TabSpec spec = tabs.newTabSpec("tag1");
    	
    	spec.setContent(new TabHost.TabContentFactory() {
			public View createTabContent(String tag) {
				return new AnalogClock(DynamicTabDemo.this);
			}
		});
    	
    	spec.setIndicator("Heure");
    	tabs.addTab(spec);
    }
}
