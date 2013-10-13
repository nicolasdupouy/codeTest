package com.example.chrono;

import java.text.DateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class ChronoActivity extends Activity {

	DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();
	TextView dateAndTimelabel;
	Calendar dateAndTime = Calendar.getInstance();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        
        dateAndTimelabel=(TextView)findViewById(R.id.dateAndTime);
        
        updateLabel();
    }
    
    public void chooseDate(View v) {
    	new DatePickerDialog(ChronoActivity.this, d, 
    						 dateAndTime.get(Calendar.YEAR),
    						 dateAndTime.get(Calendar.MONTH),
    						 dateAndTime.get(Calendar.DAY_OF_MONTH))
    	.show();
    }
    
    public void chooseTime(View v) {
    	new TimePickerDialog(ChronoActivity.this, t,
    						 dateAndTime.get(Calendar.HOUR_OF_DAY),
    						 dateAndTime.get(Calendar.MINUTE),
    						 true)
    	.show();
    }
    
    private void updateLabel() {
    	dateAndTimelabel.setText(fmtDateAndTime.format(dateAndTime.getTime()));
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, 
							  int year, 
							  int monthOfYear,
							  int dayOfMonth) {
			dateAndTime.set(Calendar.YEAR, /*year*/ 2050);
			dateAndTime.set(Calendar.MONTH, monthOfYear);
			dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			updateLabel();
		}
    	
    };
    
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
			dateAndTime.set(Calendar.MINUTE, minute);
			updateLabel();
		}
    };
}
