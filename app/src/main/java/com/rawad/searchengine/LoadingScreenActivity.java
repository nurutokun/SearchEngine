package com.rawad.searchengine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.util.Log;

public class LoadingScreenActivity extends ActionBarActivity {
	
	// Create a new thread to update the progress of this using the setProgress(int) method
	private ProgressBar initialProgressBar;
	// Maybe main thread updates this?
	private ImageView loaderAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading_screen);
		
		initialProgressBar = (ProgressBar) findViewById(R.id.initialProgressBar);
		loaderAnimation = (ImageView) findViewById(R.id.loaderAnimation);
		
		LoadingIntentService.startActionFoo(getApplicationContext(), "first set of info", "other set of info");
		
		Log.i("com.rawad.searchengine", "loading screen activity started");
		
		new Thread(new Runnable() {
			
			public void run() {
				
				for(int i = 0; i < initialProgressBar.getMax(); i++) {
					initialProgressBar.setProgress(i);
					
					try {
						Thread.sleep(100);
					} catch(Exception ex) {
						Log.i("com.rawad.searchengine", "problem happened with the sleeping of the thread: " + ex);
					}
					
				}
				
				startActivity(new Intent(LoadingScreenActivity.this, MainActivity.class));
				
			}
			
		}).start();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_loading_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
	
}
