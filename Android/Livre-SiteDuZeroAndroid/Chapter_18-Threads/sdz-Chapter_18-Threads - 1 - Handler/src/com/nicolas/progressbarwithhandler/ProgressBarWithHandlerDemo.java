package com.nicolas.progressbarwithhandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

public class ProgressBarWithHandlerDemo extends Activity {

	private static final int PROGRESS_DIALOG_ID = 0;
	private static final int MAX_SIZE = 10;
	private static final int PROGRESSION = 0;

	private Button button = null;
	private ProgressDialog progressBar = null;
	private Thread progressionThread = null;
	private int progressionInt = 0;

	// Gère les communications avec le thread de téléchargement
	@SuppressLint("HandlerLeak")
	private final Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			progressBar.setProgress(msg.arg1);
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar_with_handler_demo);

		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(PROGRESS_DIALOG_ID);

				progressionInt = 0;

				progressionThread = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							while (progressionInt < MAX_SIZE) {
								progressionInt = download();

								Thread.sleep(1000);

								Message msg = handler.obtainMessage(PROGRESSION, progressionInt, 0);
								//msg.arg1 = progressionInt;
								handler.sendMessage(msg);
							}
							
							if (progressionInt >= MAX_SIZE) {
								runOnUiThread(new Runnable() {
									
									@Override
									public void run() {
										Toast.makeText(ProgressBarWithHandlerDemo.this, 
														R.string.over, 
														Toast.LENGTH_SHORT)
											.show();
									}
								});
								progressBar.dismiss();
							}

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				progressionThread.start();
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {

		if (progressBar == null) {
			progressBar = new ProgressDialog(this);

			progressBar.setCancelable(true);
			progressBar.setOnCancelListener(new DialogInterface.OnCancelListener() {

				@SuppressWarnings("deprecation")
				@Override
				public void onCancel(DialogInterface dialog) {
					progressionThread.interrupt();
					Toast.makeText(ProgressBarWithHandlerDemo.this, 
							R.string.cancelled, // ProgressBarWithHandlerDemo.this.getString(R.string.cancelled) 
							Toast.LENGTH_SHORT)
							.show();
					removeDialog(PROGRESS_DIALOG_ID);
				}
			});

			progressBar.setTitle("Téléchargement en cours ...");
			progressBar.setMessage("C'est long ...");
			progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressBar.setMax(MAX_SIZE);
		}

		return progressBar;
	}


	private int download() {
		if (progressionInt < MAX_SIZE) {
			return ++progressionInt;
		}
		return MAX_SIZE;
	}

}
