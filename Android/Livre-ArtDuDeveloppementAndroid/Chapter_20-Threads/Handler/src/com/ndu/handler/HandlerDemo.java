package com.ndu.handler;
import java.util.concurrent.atomic.AtomicBoolean;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;


public class HandlerDemo extends Activity {

	ProgressBar progressBar;
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			progressBar.incrementProgressBy(5);
		}
	};
	AtomicBoolean isRunning = new AtomicBoolean(false);
	
	
	@Override
	/**
	 * 
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		progressBar = (ProgressBar)findViewById(R.id.progressBar);
	}
	
	
	@Override
	/**
	 * 
	 */
	protected void onStart() {
		
		//
		super.onStart();
		
		progressBar.setProgress(0);
		
		Thread background = new Thread(new Runnable() {	
			public void run() {
				try {
					for (int i=0; i<20 && isRunning.get(); i++) {
						Thread.sleep(1000);
						handler.sendMessage(handler.obtainMessage());
					}
				}
				catch (Throwable t) {}
			}
		});
		
		isRunning.set(true);
		background.start();
	}
	
	
	@Override
	/**
	 * 
	 */
	protected void onStop() {
		super.onStop();
		isRunning.set(false);
	}
	
	
	
}
