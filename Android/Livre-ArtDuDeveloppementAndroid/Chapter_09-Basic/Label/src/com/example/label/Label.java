package com.example.label;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Label extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_label);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_label, menu);
        return true;
    }
}
