package com.nicolas.tpExplorateurDeFichiers;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class ExplorateurPreference extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}

	
}
