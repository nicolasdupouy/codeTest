package com.nicolas.tpExplorateurDeFichiers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.nicolas.tpExplorateurDeFichiers.adapter.FilePresentationAdapter;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Color;

public class TPExplorateurDeFichiers extends ListActivity implements OnSharedPreferenceChangeListener {

	private static final String COLOR_ITEM_NAME = "repertoireColorPref";
	private SharedPreferences sharedPreferences = null;
	private TextView title = null;
	private ListView list = null;
	private int color = 0;
	//private boolean wantToQuit = false;
	private File currentFile = null;
	private FilePresentationAdapter filePresentationAdapter = null;
	
	private static final String FILES_UNAVAILABLE = "The files aren't available !";
	private static final String DB_QUIT_QUESTION = "Quit ?";
	private static final String DB_WANT_TO_QUIT_QUESTION = "Do you really want to quit ?";
	private static final String ACTIVITY_NOT_FOUND = "No activity can handle this file type.";
	private static final String NON_AVAILABLE_DIRECTORY = "Non available directory !";
	private static final String EMPTY_DIRECTORY = "Empty directory !";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpexplorateur_de_fichiers);
        
        list = (ListView) getListView();
        
        /*String pathData = Environment.getDataDirectory().getAbsolutePath();
        String pathRoot = Environment.getRootDirectory().getAbsolutePath();
        
        Toast.makeText(TPExplorateurDeFichiers.this, 
        				"pathData : " 
        					+ pathData 
        					+ " / pathRoot : " 
        					+ pathRoot, 
        				Toast.LENGTH_LONG)
        .show();*/
        
        Log.d("PATH - Directory", "Data Directory : " + Environment.getDataDirectory().getAbsolutePath());
        Log.d("PATH - Directory", "Root Directory : " + Environment.getRootDirectory().getAbsolutePath());
        Log.d("PATH - Directory", "External Storage State : " + Environment.getExternalStorageState());
        Log.d("PATH - Directory", "External Storage Directory : " + Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d("PATH - Directory", "Download Cache Directory : " + Environment.getDownloadCacheDirectory().getAbsolutePath());
        
        
        /*Toast.makeText(TPExplorateurDeFichiers.this, 
				"The external Storage Directory will be used by default if available: " + Environment.getExternalStorageDirectory(), 
				Toast.LENGTH_LONG)
		.show();*/

        
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
        	title = (TextView)list.getEmptyView();
            title.setText(FILES_UNAVAILABLE);
            
			/*Toast.makeText(TPExplorateurDeFichiers.this, "The directory " + Environment.getExternalStorageState() + " is not available !", Toast.LENGTH_SHORT)
			.show();*/
        }
        else {
        	//
        	registerForContextMenu(list);
        	
        	// On récupère les préférences de l'application 
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        	// On indique que l'acitivté est à l'écoute des changements de préférence
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        	// On récupère la couleur voulue par l'utilisateur, par défaut il s'agira du rouge
        	color = sharedPreferences.getInt(COLOR_ITEM_NAME, Color.RED);
        	
        	currentFile = Environment.getExternalStorageDirectory();
        	setTitle(currentFile.getAbsolutePath());
        	
        	//Log.d("MISC", String.valueOf(currentFile.getTotalSpace()));
        	List<File> filesList = new ArrayList<File>();
        	//List<String> filesListString = new ArrayList<String>();
        	for(File file : currentFile.listFiles()) {
        		filesList.add(file);
        		//filesListString.add(file.getName());        	
        	}
        	
        	//setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filesListString /*filesList*/));
        	filePresentationAdapter = new FilePresentationAdapter(this, android.R.layout.simple_list_item_1, filesList, color);
        	list.setAdapter(filePresentationAdapter);
        	filePresentationAdapter.sort();
        	//setListAdapter(filePresentationAdapter);
        	
        	list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> adapter, View view,
						int position, long id) {
					File file = filePresentationAdapter.getItem(position);
					if (file.isDirectory()) {
						updateDirectory(file);
					}
					else {
						watchFile(file);
					}
				}
			});
		}
    }



	/* ##################
     * ## OPTIONS Menu ##
     * ##################
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.tpexplorateur_de_fichiers, menu);
		//return true;
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()) {
		case R.id.menu_options:
			// Intent explicite
			Intent i = new Intent(this, ExplorateurPreference.class);
			startActivity(i);
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	// ##################
	
	
	 /* ##################
     * ## CONTEXT Menu ##
     * ##################
     */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuInflater menuInflater = getMenuInflater();
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
		
		File file = filePresentationAdapter.getItem(info.position);
		if (file.isDirectory()) {
			menuInflater.inflate(R.menu.context_dir, menu);
		}
		else {
			menuInflater.inflate(R.menu.context_file, menu);
		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		File file = filePresentationAdapter.getItem(info.position);
		switch (item.getItemId()) {
		case R.id.deleteItem:
			filePresentationAdapter.remove(file);
			file.delete();
			return true;
		case R.id.seeItem:
			watchFile(file);
			return true;
		}
		
		return super.onContextItemSelected(item);
	}
	// ##################

	
	/* #######################
     * ## PRIVATE Functions ##
     * #######################
     */
	/**
	 * 
	 * @param directory
	 */
	public void updateDirectory(File directory) {
		setTitle(directory.getAbsolutePath());
		
		//wantToQuit = false;
		currentFile = directory;
		setEmpty();

		File[] fileTab = currentFile.listFiles();
		if (currentFile.listFiles() == null) {
			Toast.makeText(this, NON_AVAILABLE_DIRECTORY, Toast.LENGTH_SHORT).show();
		}
		else if (currentFile.listFiles().length == 0) {
			Toast.makeText(this, EMPTY_DIRECTORY, Toast.LENGTH_SHORT).show();
		}
		else {
			for(File file : currentFile.listFiles()) {
				filePresentationAdapter.add(file);   	
			}
			filePresentationAdapter.sort();
		}
	}

	/**
	 * 
	 * @param file
	 */
	private void watchFile(File file) {
		
		Intent intent = new Intent(Intent.ACTION_VIEW);
		
		MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
		String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1).toLowerCase();
		String type = mimeTypeMap.getMimeTypeFromExtension(extension);
		
		intent.setDataAndType(Uri.fromFile(file), type);

		try {
			startActivity(intent);
		}
		catch (ActivityNotFoundException e) {
			Toast.makeText(this, ACTIVITY_NOT_FOUND, Toast.LENGTH_SHORT).show();
		}
	}
	
	/**
	 * 
	 */
	public void setEmpty() {
		if (!filePresentationAdapter.isEmpty()) {
			filePresentationAdapter.clear();
		}
	}
	
	// #######################

	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			File parent = currentFile.getParentFile();
			if (parent != null) {
				updateDirectory(parent);
			}
			else {
				/*if (wantToQuit == true) {
					finish();
				}
				else {*/
				//wantToQuit = true;
				new AlertDialog.Builder(this)
				.setTitle(DB_QUIT_QUESTION)
				.setMessage(DB_WANT_TO_QUIT_QUESTION)
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Do nothing
					}
				})
				.show();

				//Toast.makeText(this, WANT_TO_QUIT_QUESTION, Toast.LENGTH_SHORT).show();
				//}
			}
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		color = sharedPreferences.getInt(COLOR_ITEM_NAME, Color.BLACK);
		filePresentationAdapter.notifyDataSetInvalidated();
	}
}
