package com.example.rotationone;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.app.Activity;
import android.app.backup.RestoreObserver;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class RotationOneDemo extends Activity {

	static final int PICK_REQUEST = 1337;
	Button viewButton = null;
	Uri contact = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        viewButton = (Button)findViewById(R.id.view);
        //restoreMe(savedInstanceState);
        
        //viewButton.setEnabled(contact!=null);
    }

    
    /* ###############
     * ## Callbacks ##
     * ###############
     */
	public void pickContact(View view) {
    	/*Intent i = new Intent(Intent.ACTION_PICK,
    						  Contacts.CONTENT_URI);*/
		Intent i = new Intent(Intent.ACTION_PICK,
							  ContactsContract.Contacts.CONTENT_URI);
    	startActivityForResult(i, PICK_REQUEST);
    }
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
    	if (requestCode==PICK_REQUEST) {
    		if (resultCode==RESULT_OK) {
    			contact = data.getData();
    			viewButton.setEnabled(true);
    		}
    	}
	}
	
    public void viewContact(View view) {
    	startActivity(new Intent(Intent.ACTION_VIEW, contact));
    }
    
     
    
    /* ###############################
     * ## save and restore Instance ##
     * ###############################
     */
    // Méthodes utilisées lorsque l'on bascule le téléphone (rotation)
    // ou lorsque l'on revient sur l'écran avec les boutons.
    @Override
	protected void onSaveInstanceState(Bundle outState) {
		
		super.onSaveInstanceState(outState);
		
		if (contact != null) {
			outState.putString("contact", contact.toString());
		}
	}

    
    /* Remplace avantageusement les fonctions:
     * 
       restoreMe(savedInstanceState);
       viewButton.setEnabled(contact!=null);
     */
	/*@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		
		//super.onRestoreInstanceState(savedInstanceState);
		String contactUri = savedInstanceState.getString("contact");
		
		if (contactUri != null) {
			contact = Uri.parse(contactUri);
			viewButton.setEnabled(contact != null);
		}
	}*/


	private void restoreMe(Bundle state) {
    	contact = null;
    	
    	if (state != null) {
    		String contactUri = state.getString("contact");
    		
    		if (contactUri != null) {
    			contact = Uri.parse(contactUri);
    		}
    	}
    }
}
