package com.rawad.searchengine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {
	
    private DrawingView drawer;
	
	private static boolean loaded = false;

	/**
	 * A new object of any Activity is created every time the onCreate method is called (or vice versa) so the {@code loaded}
	 * variable needs to be static
	 * 
	 * @param savedInstanceState
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
        drawer = new DrawingView(this);
		
	    addContentView(drawer, new ViewGroup.LayoutParams(50, 50));// width, height
	    
	    // Check if actually loaded and change the loaded variable accordingly
	    
	    if(!loaded) {
		    loaded = true;
			
			startActivity(new Intent(this, LoadingScreenActivity.class));
	    }
	    
	    
    }
	
	public void onClick(View view) {
		
		int id = view.getId();
		
		Intent intent = null;
		
		switch(id) {
			
			case R.id.searchButton:
				// go to search activity
				intent = new Intent(this, SearchingActivity.class);
				break;
			
			case R.id.readButton:
				// go to read activity
				intent = new Intent(this, ReadingActivity.class);
				break;
			
			case R.id.gearIcon:
				// go to settings activity
				intent = new Intent(this, SettingsActivity.class);
				break;
			
		}
		
		if(intent != null) {
			startActivity(intent);
		}
		
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
