package com.Vikas.privadoo;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;

public class Entry extends Activity {
	String username;
	String password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry);
		
		SharedPreferences settings = getSharedPreferences("prefs",0);
		username = settings.getString("username","");
		password = settings.getString("password", "");
		
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				if(password.equals(""))
				{
					Intent cre = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(cre);
					finish();
				}
				else
				{
					Intent cre = new Intent(getApplicationContext(),Login.class);
					startActivity(cre);
					finish();
				}
			}
		},500);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_entry, menu);
		return true;
	}

}
