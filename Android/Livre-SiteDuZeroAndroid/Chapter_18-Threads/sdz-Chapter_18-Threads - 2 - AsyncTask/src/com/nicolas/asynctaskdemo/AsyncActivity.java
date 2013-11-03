package com.nicolas.asynctaskdemo;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

public class AsyncActivity extends Activity {

	private Button button = null;
	private ProgressDialog progressBar = null;
	private ProgressTask progressTask = null; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async);
		
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				progressTask = new ProgressTask(AsyncActivity.this);
				progressTask.execute();
			}
		});
		
		progressTask = (ProgressTask) getLastNonConfigurationInstance();
		if (progressTask != null) {
			progressTask.link(this);
		}
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {

		//if (progressBar == null) {
			progressBar = new ProgressDialog(this);

			progressBar.setCancelable(true);
			progressBar.setOnCancelListener(new DialogInterface.OnCancelListener() {

				@Override
				public void onCancel(DialogInterface dialog) {
					progressTask.cancel(true);
				}
			});

			progressBar.setTitle("Téléchargement en cours ...");
			progressBar.setMessage("C'est long ...");
			progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressBar.setMax(ProgressTask.MAX_SIZE);
		//}

		return progressBar;
	}


	public void updateProgress(int progress) {
		progressBar.setProgress(progress);
	}
	
	public void dismiss() {
		progressBar.dismiss();
	}
}
