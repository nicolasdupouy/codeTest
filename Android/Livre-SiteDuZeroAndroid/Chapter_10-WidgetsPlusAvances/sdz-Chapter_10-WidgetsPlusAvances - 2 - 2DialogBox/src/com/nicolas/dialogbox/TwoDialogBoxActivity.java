package com.nicolas.dialogbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.Dialog;

public class TwoDialogBoxActivity extends Activity {

	private Button button = null;
	private static final int NB_APPELS_MAX = 5;
	private static final int ID_NORMAL_DIALOG = 1;
	private static final int ID_ENERVEE_DIALOG = 2;
	private int compteur = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_dialog_box);
        
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (++compteur <= NB_APPELS_MAX) {
					showDialog(ID_NORMAL_DIALOG);
				}
				else {
					showDialog(ID_ENERVEE_DIALOG);
				}
			}
		});
    }


	@Override
	protected Dialog onCreateDialog(int id) {
		
		Dialog box = null;
		switch(id) {
		case ID_NORMAL_DIALOG:
			box = new Dialog(this);
			box.setContentView(R.layout.dialog);
			box.setTitle("Je viens tout juste de naître !");
			break;
		case ID_ENERVEE_DIALOG:
			box = new Dialog(this);
			box.setTitle("Mais FUCK, dégage !");
			break;	
		}
		
		return box;
	}


	@Override
	protected void onPrepareDialog(int id, Dialog box) {
		if (id == ID_NORMAL_DIALOG && compteur > 1) {
			box.setTitle("On est au " + compteur + "ème lancement !");
		}
	}
    
    
}
