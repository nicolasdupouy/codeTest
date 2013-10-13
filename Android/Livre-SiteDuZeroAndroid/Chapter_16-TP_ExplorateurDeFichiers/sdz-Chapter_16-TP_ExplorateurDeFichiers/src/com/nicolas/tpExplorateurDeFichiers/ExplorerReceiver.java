package com.nicolas.tpExplorateurDeFichiers;

import java.io.File;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ExplorerReceiver extends BroadcastReceiver {

	private TPExplorateurDeFichiers tPExplorateurDeFichiers = null;
	
	public ExplorerReceiver(TPExplorateurDeFichiers tPExplorateurDeFichiers) {
		super();
		this.tPExplorateurDeFichiers = tPExplorateurDeFichiers;
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		
		if (Intent.ACTION_MEDIA_REMOVED.equals(intent.getAction())) {
			tPExplorateurDeFichiers.setEmpty();
		}
		else if (Intent.ACTION_MEDIA_MOUNTED.equals(intent.getAction())) {
			tPExplorateurDeFichiers.updateDirectory(new File(intent.getData().toString()));
		}
	}

}
