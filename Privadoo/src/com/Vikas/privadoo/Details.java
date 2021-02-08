package com.Vikas.privadoo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends Activity {
	
     String  id;
     ImageButton delete;
     database db;
     
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		TextView notet = (TextView)findViewById(R.id.notet);
		TextView noted=(TextView)findViewById(R.id.noted);
		
		Intent i = getIntent();
		id = i.getStringExtra("id");
		database db = new database(this);
		Cursor data=db.getnotes(id);
		if(data.getCount() == 0)
		{
			noted.setText("vikas");
			notet.setText(id);
		}
		else
		{
			if(data !=null)
				data.moveToFirst();
			do
			{
			notet.setText(data.getString(0));
			noted.setText(data.getString(1));
			}
			while(data.moveToNext());
		}
		delete=(ImageButton)findViewById(R.id.delete);
		@SuppressWarnings("unused")
		final
		database base=new database(this);
		delete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
		    boolean v =base.delete(id);
		    if(v==true)
		    {
		    	Toast.makeText(getApplicationContext(), "note deleted",Toast.LENGTH_SHORT).show();
		    	Intent i = new Intent(getApplicationContext(),Home.class);
		    	startActivity(i);
		    }
		    else
		    {
		    	Toast.makeText(getApplicationContext(), "note not deleted",Toast.LENGTH_SHORT).show();
		    }
			}
		});
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_details, menu);
		return true;
	}

}
