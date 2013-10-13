package com.example.xml;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class XMLResourceDemo extends ListActivity {

	TextView selection;
	ArrayList<String> items = new ArrayList<String>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlresource_demo);
        selection = (TextView)findViewById(R.id.selection);
        
        try {
        	XmlPullParser xpp = getResources().getXml(R.xml.words);
        	
        	while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
        		if (xpp.getEventType() == XmlPullParser.START_TAG) {
        			if (xpp.getName().equals("word")) {
        				items.add(xpp.getAttributeValue(0));
        			}
        		}
        		xpp.next();
        	}
        } catch(Throwable t) {
        	Toast
        		.makeText(this, "Echec de la requête : " + t.toString(), Toast.LENGTH_LONG)
        		.show();
        }
        
        setListAdapter(new ArrayAdapter<String>(this, 
        										android.R.layout.simple_list_item_1,
        										items));
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		selection.setText(items.get(position).toString());
	}
    
    

}
