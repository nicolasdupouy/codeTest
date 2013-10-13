package com.nicolas.sondage;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainSondageActivity extends Activity {

	private ListView listSex = null;
	private ListView listLangages = null;
	private Button sendButton = null;
	private TextView resultat = null;
	
	private static String TOAST_MESSAGE_SENT = "Merci! Les données ont bien été envoyées!";
	private String[] listKnownSex = {"Masculin", "Féminin"};
	private String[] listKnownLangages = {"C", "Java", "COCOL", "Perl"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sondage);
               
        listSex = (ListView)findViewById(R.id.listSex);
        listLangages = (ListView)findViewById(R.id.listLangages);
        sendButton = (Button)findViewById(R.id.buttonSend);
        resultat = (TextView)findViewById(R.id.resultat);
        
        listSex.setAdapter(new ArrayAdapter<String>(this,
													android.R.layout.simple_list_item_single_choice, 
													listKnownSex));
        
        listLangages.setAdapter(new ArrayAdapter<String>(this,
														android.R.layout.simple_list_item_multiple_choice,
														listKnownLangages));
        
        listSex.setItemChecked(0, true);
        listLangages.setItemChecked(1, true);
        
        sendButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				displayChoices();
				blockChoices();
				Toast.makeText(MainSondageActivity.this, TOAST_MESSAGE_SENT, Toast.LENGTH_LONG)
					.show();
				sendButton.setEnabled(false);
			}
		});

    }
    
    /**
     * 
     */
    private void displayChoices() {
    	StringBuffer buffer = new StringBuffer();
		
		buffer.append("Choix: " + listKnownSex[listSex.getCheckedItemPosition()] + " / ");
		
		SparseBooleanArray sba = listLangages.getCheckedItemPositions();
		for (int i = 0; i < listKnownLangages.length; i++) {

			if (sba.get(i)) {
				buffer.append(listKnownLangages[i]);
				if (i < listKnownLangages.length - 1) {
					buffer.append(", ");
				}
				
			}
		}
		resultat.setText(buffer);
    }
    
    private void blockChoices() {
    	//listSex.setChoiceMode(ListView.CHOICE_MODE_NONE);
    	listSex.setAdapter(new ArrayAdapter<String>(this,
													android.R.layout.simple_list_item_1, 
													listKnownSex));

    	//listLangages.setChoiceMode(ListView.CHOICE_MODE_NONE);
		listLangages.setAdapter(new ArrayAdapter<String>(this,
														android.R.layout.simple_list_item_1,
														listKnownLangages));
    }

}
