package com.Vikas.privadoo;

import java.util.ArrayList;

import com.Vikas.privadoo.R.id;

import android.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity {
	TextView nonotes;
	ListView list;
	database db;
	ImageButton addnote;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		list =(ListView)findViewById(R.id.allnotestitles);
		nonotes=(TextView)findViewById(R.id.nonotes);
		addnote=(ImageButton)findViewById(R.id.addnote);
		db = new database(this);
		
		final ArrayList<String> titlelist = new ArrayList<String>();
		Cursor data = db.getlistcontents();
		
		if(data.getCount() == 0)
		{
			nonotes.setVisibility(View.VISIBLE);
		}
		else
		{
			nonotes.setVisibility(View.INVISIBLE);
			while(data.moveToNext())
			{
				titlelist.add(data.getString(0));
				ListAdapter listadapter = new ArrayAdapter<String>(this,layout.simple_expandable_list_item_1,titlelist);
				list.setAdapter(listadapter);
			}
		}
		
		addnote.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
				Intent cre = new Intent(getApplicationContext(),Addnote.class);
				startActivity(cre);
				finish();

			}
		});
		
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterview, View view, int i,
					long l) {
				Intent in = new Intent(getApplicationContext(),Details.class);
				in.putExtra("id", titlelist.get(i));
				startActivity(in);
				
				
			}
			
		});
		
		
	}
	
	@Override
	public void onBackPressed() {
		
		Intent in = new Intent(getApplicationContext(),Login.class);
		startActivity(in);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

}
