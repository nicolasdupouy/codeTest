package com.nicolas.notepad;

import com.nicolas.chapter_09_tp_blocnote.R;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;

public class NotepadActivity extends Activity {

	private static final String UNDERLINE = "u";
	private static final String ITALIC = "i";
	private static final String BOLD = "b";
	
	private Slider slider = null;
	private RelativeLayout relativeLayoutToHide = null;
	private SmileyGetter smileyGetter = null;
	private String currentColor = null;
	
	private Button buttonBold = null;
	private Button buttonItalic = null;
	private Button buttonUnderline = null;
	//private TextView smileyText = null;
	private ImageButton smileySmile = null;
	private ImageButton smileyHappy = null;
	private ImageButton smileyClin = null;
	private RadioGroup colorsGroup = null;
	private Button buttonHideShow = null;
	private Button buttonClean = null;
	private EditText edition = null;
	private TextView textPreviewed = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad_main);
        
        smileyGetter = new SmileyGetter(this);
        
        // Top level
        slider = (Slider)findViewById(R.id.slider);
        relativeLayoutToHide = (RelativeLayout)findViewById(R.id.relativeLayoutToHide);
        slider.setRelativeLayoutToHide(relativeLayoutToHide);
        
        currentColor = getResources().getString(R.color.black);
        
        // Line 1
    	buttonBold = (Button)findViewById(R.id.buttonBold);
    	buttonItalic = (Button)findViewById(R.id.buttonItalic);
    	buttonUnderline = (Button)findViewById(R.id.buttonUnderline);
        // Line 2
    	//smileyText = (TextView)findViewById(R.id.smileyText);
    	smileySmile = (ImageButton)findViewById(R.id.smileySmile);
    	smileyHappy = (ImageButton)findViewById(R.id.smileyHappy);
    	smileyClin = (ImageButton)findViewById(R.id.smileyClin);
        // Line 3
    	colorsGroup = (RadioGroup)findViewById(R.id.colorsGroup);
    	// Line 4
    	buttonHideShow = (Button)findViewById(R.id.buttonHideShow);
    	buttonClean = (Button)findViewById(R.id.buttonClean);
    	// Line 5
    	edition = (EditText)findViewById(R.id.edition);
    	textPreviewed = (TextView)findViewById(R.id.textPreviewed);
    	
    	/*
    	 * Actions
    	 */
    	// Line 1
    	buttonBold.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				formatTextButtonBold();
			}
		});
    	buttonItalic.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				formatTextButtonItalic();
			}
		});
    	buttonUnderline.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				formatTextButtonUnderline();
			}
		});
    	
    	// Line 2
    	smileySmile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				formatSmileyButtonSmile();
			}
		});
    	
    	// Line 2
    	smileyClin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				formatSmileyButtonClin();
			}
		});
    	
    	// Line 2
    	smileyHappy.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				formatSmileyButtonHappy();
			}
		});
    	
    	// Line 3
    	colorsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch(checkedId) {
				case R.id.radioBlack:
					currentColor = "#000000"; //getResources().getString(R.color.black);
					break;
					
				case R.id.radioBlue:
					currentColor = "#0022FF"; //getResources().getString(R.color.blue);
					break;
				
				case R.id.radioRed:
					currentColor = "#FF0000"; //getResources().getString(R.color.red);
					break;
				}
				// To activate the TextWatcher on the EditText and then change the color.
				edition.setText(edition.getText().toString());
			}
		});
    	
    	// Line 4
    	buttonHideShow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (slider.toggle()) {
					buttonHideShow.setText(R.string.hide);
				}
				else {
					buttonHideShow.setText(R.string.show);
				}
			}
		});
		
    	
    	buttonClean.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				edition.getText().clear();
			}
		});
    	
        // Line 5
    	edition.setOnKeyListener(new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				int cursorPosition = edition.getSelectionStart();
				if ((event.getAction() == KeyEvent.ACTION_DOWN)
						&& keyCode == 66) {
					edition.getText().insert(cursorPosition, "<br />");
				}
				return true;
			}
		});
    	
    	edition.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Spanned spannedText = Html.fromHtml("<font color=\"" + currentColor + "\">" 
															+ edition.getText().toString() 
															+ "</font>",
													smileyGetter,
													null);
				textPreviewed.setText(spannedText);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {}
			
			@Override
			public void afterTextChanged(Editable s) {}
		});
    	
    	
        Log.d("TagTest", "blablabla !!!");
    }
    
    
    private void formatTextButtonBold() {
    	this.formatTextButton(BOLD);
    }
    private void formatTextButtonItalic() {
    	this.formatTextButton(ITALIC);
    }
    private void formatTextButtonUnderline() {
    	this.formatTextButton(UNDERLINE);
    }
    
    /**
     * 
     * @param formatLetter
     */
    private void formatTextButton(String formatLetter) {
    	int selectionStart = edition.getSelectionStart();
    	int selectionEnd = edition.getSelectionEnd();
    	
    	Editable editable = edition.getText();
    	
    	if (selectionStart == selectionEnd) {
    		editable.insert(selectionStart, "<"+formatLetter+"></"+formatLetter+">");
    	}
    	else {
    		editable.insert(selectionEnd, "</"+formatLetter+">");
    		editable.insert(selectionStart, "<"+formatLetter+">");
    	}
    }
    
    private void formatSmileyButtonHappy() {
    	this.formatSmileyButton(SmileyGetter.HAPPY);
    }
    private void formatSmileyButtonClin() {
    	this.formatSmileyButton(SmileyGetter.CLIN);
    }
    private void formatSmileyButtonSmile() {
    	this.formatSmileyButton(SmileyGetter.SMILE);
    }
    
    /**
     * 
     * @param smileyTextType
     */
    private void formatSmileyButton(String smileyTextType) {
    	int selectionStart = edition.getSelectionStart();
    	edition.getText().insert(selectionStart, "<img src=\"" + smileyTextType + "\" >");
    }
    
}
