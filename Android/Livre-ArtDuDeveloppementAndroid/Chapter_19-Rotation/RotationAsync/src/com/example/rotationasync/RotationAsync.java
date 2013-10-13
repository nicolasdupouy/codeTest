package com.example.rotationasync;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class RotationAsync extends Activity {

	private ProgressBar progressBar = null;
	private RotationAwareTask rotationAwareTask = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_async);
        
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        rotationAwareTask = (RotationAwareTask)getLastNonConfigurationInstance();
        
        if (rotationAwareTask== null) {
        	rotationAwareTask = new RotationAwareTask(this);
        	rotationAwareTask.execute();
        }
        else {
        	rotationAwareTask.attach(this);
        	updateProgress(rotationAwareTask.getProgress());
        	
        	if (rotationAwareTask.getProgress() >= 100) {
        		markAsDone();
        	}
        }
    }

    @Override
	public Object onRetainNonConfigurationInstance() {
		rotationAwareTask.detach();
		
		return rotationAwareTask;
	}

    void updateProgress(int progress) {
    	progressBar.setProgress(progress);
    }
    
    void markAsDone() {
    	findViewById(R.id.completed)
    		.setVisibility(View.VISIBLE);
    }
    
    
    
	static class RotationAwareTask extends AsyncTask<Void, Void, Void> {
    	RotationAsync activity = null;
    	int progress = 0;
    	
    	public RotationAwareTask(RotationAsync activity) {
			attach(activity);
		}

		@Override
		protected Void doInBackground(Void... unused) {
			
			for(int i=0; i<20; i++) {
				SystemClock.sleep(500);
				publishProgress();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			if (activity==null) {
				Log.w("RotationAsync", "onProgressUpdate() skipped -- no activity");
			}
			else {
				progress += 5;
				activity.updateProgress(progress);
			}
		}
    	
		@Override
		protected void onPostExecute(Void result) {
			if (activity==null) {
				Log.w("RotationAsync", "onPostExecute() skipped -- no activity");
			}
			else {
				activity.markAsDone();
			}
		}

		void detach() {
			activity = null;
		}
		
		void attach(RotationAsync activity) {
			this.activity = activity;
		}
		
		int getProgress() {
			return progress;
		}
    }
}
