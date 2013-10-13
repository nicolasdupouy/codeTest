package com.example.calculimcpartie3_3;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	private static final String texteElogieux = "Quel poids parfait, c'est merveilleux !";
	private static final String welcomeText = "Welcome ! Unleashed hell ... ";
	private static final String defaultText = "Vous devez cliquer sur le bouton \"calculer l'IMC\" pour obtenir un résultat.";
	private static final String toastTextPoidsZero = "Erreur: Le poids ne peut pas être nul !";
	private static final String toastTextTailleZero = "Erreur: La taille ne peut pas être nulle !";

	private static final String DOUBLE_ZERO = "0.0";
	private static final String EMPTY_STRING = "";
	
	EditText poidsEditText;
	EditText tailleEditText;
	RadioGroup groupeRadioGroup;
	CheckBox megaFunctionCheckBox;
	Button calculerIMCButton;
	Button razButton;
	TextView resultTextView;

	/// Listener for the EditText poidsEditText and tailleEditText
	private TextWatcher editTextTextWatcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			resultTextView.setText(defaultText);
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

		@Override
		public void afterTextChanged(Editable s) {}
	};

	/// listener for CheckBox megaFunctionCheckBox
	private OnClickListener megaFunctionOnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (megaFunctionCheckBox.isChecked() && !texteElogieux.equals(resultTextView.getText())) {
				resultTextView.setText(texteElogieux);
			}
			else {
				resultTextView.setText(defaultText);
			}
		}
	};

	/// listener for Button calculerIMCButton
	private OnClickListener calculerIMCOnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			calculerIMC();
		}
	};

	/// listener for Button razButton
	private OnClickListener razOnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			poidsEditText.getText().clear();
			tailleEditText.getText().clear();
			groupeRadioGroup.check(1);
			megaFunctionCheckBox.setChecked(false);
			resultTextView.setText(defaultText);
		}
	};


	private void calculerIMC() {
		int choice = groupeRadioGroup.getCheckedRadioButtonId();
		Editable poidsEditable = poidsEditText.getText();
		Editable tailleEditable = tailleEditText.getText();

		String sPoids = poidsEditable.toString();
		String sTaille = tailleEditable.toString();
		double poids = Double.valueOf(DOUBLE_ZERO);
		double taille = Double.valueOf(DOUBLE_ZERO);
		
		if (sPoids != null && !EMPTY_STRING.equals(sPoids)) {
			poids = Double.parseDouble(sPoids);
		}
		if (sTaille != null && !EMPTY_STRING.equals(sTaille)) {
			taille = Double.parseDouble(sTaille);
		}
		if (taille == 0) {
			Toast.makeText(this, toastTextTailleZero, Toast.LENGTH_SHORT)
			.show();
		}
		else if (poids == 0) {
			Toast.makeText(this, toastTextPoidsZero, Toast.LENGTH_SHORT)
			.show();
		}
		else {
			if (choice==R.id.radioCentimetre) {
				taille /=100;;
			}
			double imc = poids/Math.pow(taille, 2);
			resultTextView.setText("Votre IMC est : " + imc);
		}
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		poidsEditText = (EditText)findViewById(R.id.poids);
		tailleEditText = (EditText)findViewById(R.id.taille);
		groupeRadioGroup = (RadioGroup)findViewById(R.id.groupe);
		megaFunctionCheckBox = (CheckBox)findViewById(R.id.megaFonction);
		calculerIMCButton = (Button)findViewById(R.id.calculerIMC);
		razButton = (Button)findViewById(R.id.raz);
		resultTextView = (TextView)findViewById(R.id.result);
		
		resultTextView.setText(welcomeText);

		poidsEditText.addTextChangedListener(editTextTextWatcher);
		tailleEditText.addTextChangedListener(editTextTextWatcher);
		megaFunctionCheckBox.setOnClickListener(megaFunctionOnClickListener);
		calculerIMCButton.setOnClickListener(calculerIMCOnClickListener);
		razButton.setOnClickListener(razOnClickListener);
	}



}
