package com.nicolas.stockageInterneExterne;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	private static final String NOM_FICHIER = "FichierPrenom.txt";
	private static final String monPseudo = "Nicolas";
	private File externalFile = null;
	
	private Button buttonReadInternal = null;
	private Button buttonWriteInternal = null;
	private Button buttonReadExternal = null;
	private Button buttonWriteExternal = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		buttonReadInternal = (Button)findViewById(R.id.buttonReadInternalFile);
		buttonWriteInternal = (Button)findViewById(R.id.buttonWriteInternalFile);
		buttonReadExternal = (Button)findViewById(R.id.buttonReadExternalFile);
		buttonWriteExternal = (Button)findViewById(R.id.buttonWriteExternalFile);

		externalFile = new File(Environment.getExternalStorageDirectory().getPath() 
								+ "/Android/data/" 
								+ getPackageName() 
								+ "/files/" 
								+ NOM_FICHIER);

		buttonReadInternal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				readInternalFile();
			}
		});

		buttonWriteInternal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				writeInternalFile();
			}
		});

		buttonReadExternal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				readExternalFile();
			}
		});

		buttonWriteExternal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				writeExternalFile();
			}
		});

	}

	/**
	 * 
	 */
	private void readInternalFile() {
		try {
			FileInputStream internalInputFile =  openFileInput(NOM_FICHIER);
			int value;
			StringBuffer stringBuffer = new StringBuffer();

			while( (value = internalInputFile.read()) != -1 ) {
				stringBuffer.append((char)value);
			}

			Toast.makeText(MainActivity.this, "Interne: " + stringBuffer.toString(), Toast.LENGTH_SHORT)
			.show();

			if (internalInputFile != null) {
				internalInputFile.close();
			}

		} catch (FileNotFoundException e) {
			Toast.makeText(MainActivity.this, "Le fichier interne " + NOM_FICHIER + " n'existe pas !", Toast.LENGTH_SHORT)
			.show();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void writeInternalFile() {
		try {
			FileOutputStream internalOutputFile =  openFileOutput(NOM_FICHIER, MODE_PRIVATE);
			internalOutputFile.write(monPseudo.getBytes());
			
			if (internalOutputFile != null) {
				internalOutputFile.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void readExternalFile() {
		try {
			/*if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
					&& !Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
				Toast.makeText(MainActivity.this, "Le fichier externe " + NOM_FICHIER + " n'est pas accessible !", Toast.LENGTH_SHORT)
				.show();
			}
			else {
				FileInputStream externalInputFile =  openFileInput(NOM_FICHIER);
				int value;
				StringBuffer stringBuffer = new StringBuffer();

				while( (value = externalInputFile.read()) != -1 ) {
					stringBuffer.append((char)value);
				}

				Toast.makeText(MainActivity.this, "Externe: " + stringBuffer.toString(), Toast.LENGTH_SHORT)
				.show();

				if (externalInputFile != null) {
					externalInputFile.close();
				}
			}*/
			if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
					|| Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
				FileInputStream externalInputFile =  new FileInputStream(externalFile);
				int value;
				StringBuffer stringBuffer = new StringBuffer();

				while( (value = externalInputFile.read()) != -1 ) {
					stringBuffer.append((char)value);
				}
				
				Toast.makeText(MainActivity.this, "Externe: " + stringBuffer.toString(), Toast.LENGTH_SHORT)
				.show();

				if (externalInputFile != null) {
					externalInputFile.close();
				}
			}
			else {
				Toast.makeText(MainActivity.this, "Le fichier externe " + NOM_FICHIER + " n'est pas accessible !", Toast.LENGTH_SHORT)
				.show();
			}

		} catch (FileNotFoundException e) {
			Toast.makeText(MainActivity.this, "Le fichier externe " + NOM_FICHIER + " n'existe pas !", Toast.LENGTH_SHORT)
			.show();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void writeExternalFile() {
		try {
			if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
				Toast.makeText(MainActivity.this, "Le fichier externe " + NOM_FICHIER + " n'est pas accessible en lecture/écriture !", Toast.LENGTH_SHORT)
				.show();
			}
			else {
				externalFile.createNewFile();
				FileOutputStream externalOutputFile =  new FileOutputStream(externalFile); //openFileOutput(NOM_FICHIER, MODE_PRIVATE);
				externalOutputFile.write(monPseudo.getBytes());

				if (externalOutputFile != null) {
					externalOutputFile.close();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
