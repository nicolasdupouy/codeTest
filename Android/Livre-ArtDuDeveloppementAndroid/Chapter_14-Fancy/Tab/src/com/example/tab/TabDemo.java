package com.example.tab;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TabHost;
import android.widget.TabWidget;

public class TabDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TabHost tabHost = (TabHost)findViewById(R.id.tabhost);
        tabHost.setup();
        //tabHost.s
        
        //TabWidget tabWidget = (TabWidget)findViewById(R.id.tabs);
        
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Heure");
        tabHost.addTab(tabSpec);
        
        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Bouton");
        tabHost.addTab(tabSpec);
        
        tabHost.setCurrentTab(0);
    }
}
