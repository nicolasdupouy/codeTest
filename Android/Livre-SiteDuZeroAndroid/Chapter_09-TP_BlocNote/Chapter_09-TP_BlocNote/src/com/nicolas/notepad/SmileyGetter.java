package com.nicolas.notepad;

import com.nicolas.chapter_09_tp_blocnote.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;

public class SmileyGetter implements ImageGetter {

	public static final String HAPPY = "happy";
	public static final String CLIN = "clin";
	public static final String SMILE = "smile";
	
	private Context context = null;
	
	public SmileyGetter(Context context) {
		this.context = context;
	}
	
	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public Drawable getDrawable(String smiley) {
		Drawable drawable =  null;
		
		Resources resources = context.getResources();
		if(CLIN.equals(smiley)) {
			drawable = resources.getDrawable(R.drawable.smiley_clin);
		}
		else if(HAPPY.equals(smiley)) {
			drawable = resources.getDrawable(R.drawable.smiley_happy);
		}
		else if(SMILE.equals(smiley)) {
			drawable = resources.getDrawable(R.drawable.smiley_smile);
		}
		
		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
		
		return drawable;
	}

}
