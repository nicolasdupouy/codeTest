package com.example.asyncer;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class AsyncDemo extends ListActivity {

	private static final String[] items = { "item 1", "item a", 
											"item 2", "item b", 
											"item 3", "item c",
											"item 4", "item d",
											"item 5", "item e"};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setListAdapter(new ArrayAdapter<String>(this,
        										android.R.layout.simple_list_item_1, 
        										new ArrayList<String>()));
        
        new AddStringTask().execute();
    }

    
    class AddStringTask extends AsyncTask<Void, String, Void> {

		@Override
		protected Void doInBackground(Void... unused) {
			for (String item : items) {
				publishProgress(item);
				SystemClock.sleep(200);
			}
			
			return null;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void onProgressUpdate(String... values) {
			((ArrayAdapter<String>)getListAdapter()).add(values[0]);
		}
		
		@Override
		protected void onPostExecute(Void result) {
			Toast
				.makeText(AsyncDemo.this, "Fini !", Toast.LENGTH_LONG)
				.show();
		}

	
    }
}
