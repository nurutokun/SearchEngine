package com.rawad.searchengine;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {
	
    private DrawingView drawer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
        drawer = new DrawingView(this);
		
        setContentView(drawer);
		
    }
	
	public void onClick(View view) {
		
		int id = view.getId();
		
		switch(id) {
			
			case R.id.searchButton:
				// go to search activity
				break;
			
			case R.id.readButton:
				// go to read activity
				break;
			
			case R.id.gearIcon:
				// go to settings activity
				break;
			
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
