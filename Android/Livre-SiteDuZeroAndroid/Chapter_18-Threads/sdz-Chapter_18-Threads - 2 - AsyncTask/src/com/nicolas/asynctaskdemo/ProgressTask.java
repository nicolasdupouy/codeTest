package com.nicolas.asynctaskdemo;

import java.lang.ref.WeakReference;

import android.os.AsyncTask;
import android.widget.Toast;

public class ProgressTask extends AsyncTask<Void, Integer, Boolean> {

	private static final int PROGRESS_DIALOG_ID = 0;
	public static final int MAX_SIZE = 10;
	
	private WeakReference<AsyncActivity> activityWeakReference = null;
	private int progressionInt = 0;
	
	public ProgressTask(AsyncActivity asyncActivity) {
		link(asyncActivity);
	}
	
	@Override
	protected void onPreExecute() {
		if (activityWeakReference.get() != null) {
			activityWeakReference.get().showDialog(PROGRESS_DIALOG_ID);
		}
	}

	@Override
	protected Boolean doInBackground(Void... params) {

		try {
			while (download() <= MAX_SIZE) {
				publishProgress(progressionInt);
				Thread.sleep(1000);
			}
			return true;
		}
		catch(InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		if (activityWeakReference.get() != null) {
			activityWeakReference.get().updateProgress(values[0]);
		}
	}
	
	@Override
	protected void onPostExecute(Boolean result) {
		
		if (activityWeakReference.get() != null) {
			String text;
			if (result) {
				text = "Téléchargement terminé";
			}
			else {
				text = "Echec du téléchargement";
			}
			
			activityWeakReference.get().dismiss();
			Toast.makeText(activityWeakReference.get(), 
					text,
					Toast.LENGTH_SHORT)
					.show();
		}
	}
	
	@Override
	protected void onCancelled() {
		if (activityWeakReference.get() != null) {
			Toast.makeText(activityWeakReference.get(), 
					R.string.cancelled, // ProgressBarWithHandlerDemo.this.getString(R.string.cancelled) 
					Toast.LENGTH_SHORT)
					.show();
		}
	}
	
	public void link (AsyncActivity asyncActivity) {
		activityWeakReference = new WeakReference<AsyncActivity>(asyncActivity);
	}
	
	private int download() {
		if (progressionInt <= MAX_SIZE) {
			return ++progressionInt;
		}
		return progressionInt; //MAX_SIZE;
	}
}
