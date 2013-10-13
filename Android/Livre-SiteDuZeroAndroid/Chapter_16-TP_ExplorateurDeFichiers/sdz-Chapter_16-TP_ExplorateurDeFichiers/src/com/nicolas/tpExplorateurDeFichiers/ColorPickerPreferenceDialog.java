package com.nicolas.tpExplorateurDeFichiers;


import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.Color;
import android.preference.DialogPreference;
import android.util.AttributeSet;

import com.nicolas.tpExplorateurDeFichiers.ColorPickerView.OnColorChangedListener;

public class ColorPickerPreferenceDialog extends DialogPreference implements OnColorChangedListener {

	private int color = 0;
	
	public ColorPickerPreferenceDialog(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	@Override
	/**
	 * Pour construire la boite de dialogue.
	 */
	protected void onPrepareDialogBuilder(Builder builder) {
		// oldColor (otherwise default color is black).
		int oldColor = getSharedPreferences().getInt(getKey(), Color.BLACK);
		// On insère la vue dans la boite de dialogue.
		builder.setView(new ColorPickerView(getContext(), this, oldColor));
		
		super.onPrepareDialogBuilder(builder);
	}

	@Override
	/**
	 * Déclenché dès qu'on ferme la boite de dialogue.
	 */
	protected void onDialogClosed(boolean positiveResult) {
		if (positiveResult) {
			persistInt(color);
			// ou
			//getSharedPreferences().edit().putInt(getKey(), color).commit();
		}
		
		super.onDialogClosed(positiveResult);
	}



	@Override
	public void colorChanged(int color) {
		this.color = color;
	}

}
