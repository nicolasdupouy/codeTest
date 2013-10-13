package com.example.inflation;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;

public class MenuInflationDemo extends ListActivity {

	private static final String[] items={"item 1", "item a", 
		"item 2", "item b", 
		"item 3", "item c",
		"item 4", "item d",
		"item 5", "item e"};
	
	private ArrayList<String> words = null;
	
	
	/**
     * 
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        initAdapter();
        registerForContextMenu(getListView());
    }

    
    /* ##################
     * ## OPTIONS Menu ##
     * ##################
     */
    
    /**
     * 
     */
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
    	/*menu.add(Menu.NONE, MENU_ADD, Menu.NONE, "Ajouter")
    		.setIcon(R.drawable.ic_menu_add);
    	menu.add(Menu.NONE, MENU_RESET, Menu.NONE, "Réinitialiser")
			.setIcon(R.drawable.ic_menu_refresh);*/
    	new MenuInflater(this).inflate(R.menu.option, menu);
    	
		return super.onCreateOptionsMenu(menu);
	}
    
    /**
     * 
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.add:
			add();
			return true;

		case R.id.reset:
			initAdapter();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
    
	
	/* ##################
     * ## CONTEXT Menu ##
     * ##################
     */
    /**
     * 
     */
    @Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		
    	/*menu.add(Menu.NONE, MENU_CAP, Menu.NONE, "Capitaliser");
    	menu.add(Menu.NONE, MENU_REMOVE, Menu.NONE, "Supprimer");*/
    	new MenuInflater(this).inflate(R.menu.context, menu);
	}
	
	/**
     * 
     */
    @Override
	public boolean onContextItemSelected(MenuItem item) {
	
    	AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
    	ArrayAdapter<String> adapter = (ArrayAdapter<String>)getListAdapter();
		
    	switch (item.getItemId()) {
		case R.id.cap:
			String word = words.get(info.position);
			word = word.toUpperCase();
			adapter.remove(words.get(info.position));
			adapter.insert(word, info.position);
			return true;

		case R.id.remove:
			adapter.remove(words.get(info.position));
			return true;
		}
    	
    	return super.onContextItemSelected(item);
	}


    /* #######################
     * ## private functions ##
     * #######################
     */
    /**
     * 
     */
	private void initAdapter() {
    	words = new ArrayList<String>();
    	
    	for ( String s : items) {
    		words.add(s);
    	}
    	
    	setListAdapter(new ArrayAdapter<String>(this, 
    											android.R.layout.simple_list_item_1, words));
    }
    
	/**
	 * 
	 */
    private void add() {
    	final View addView =  getLayoutInflater().inflate(R.layout.add, null);
    	
    	new AlertDialog.Builder(this)
    		.setTitle("Ajouter un mot")
    		.setView(addView)
    		.setPositiveButton("OK", 
    						   new DialogInterface.OnClickListener() {
								
								public void onClick(DialogInterface dialog, int which) {
									ArrayAdapter<String> adapter = (ArrayAdapter<String>)getListAdapter();
									EditText title = (EditText)addView.findViewById(R.id.title);
									adapter.add(title.getText().toString());
								}
							})
			.setNegativeButton("Annuler", null)
			.show();
    }
}
