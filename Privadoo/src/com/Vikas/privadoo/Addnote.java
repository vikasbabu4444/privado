package com.Vikas.privadoo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Addnote extends Activity {
	ImageButton back,save;
	TextView noteheading;
	EditText notetitle,notedetails;
	database db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addnote);
		
		back=(ImageButton)findViewById(R.id.back);
		save =(ImageButton)findViewById(R.id.save);
		noteheading=(TextView)findViewById(R.id.notetitlenote);
		notetitle=(EditText)findViewById(R.id.addtitle);
		notedetails=(EditText)findViewById(R.id.addnotes);
		db = new database(this);
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),Home.class);
				startActivity(i);
				finish();
			}
		});

		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
				String title,desc;
				desc=notedetails.getText().toString();
				title=notetitle.getText().toString();
				boolean v = db.addData(title,desc);
				if(v==true)
				{
					Toast.makeText(getApplicationContext(), "note saved", Toast.LENGTH_SHORT).show();
					Intent i = new Intent(getApplicationContext(),Home.class);
					startActivity(i);
					finish();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "note did not saved", Toast.LENGTH_SHORT).show();
					Intent i = new Intent(getApplicationContext(),Home.class);
					startActivity(i);
					finish();
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_addnote, menu);
		return true;
	}

}
