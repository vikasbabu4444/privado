package com.Vikas.privadoo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText et,et1,et2,ph;
	Button reg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et =  (EditText)findViewById(R.id.username);
		et1 = (EditText)findViewById(R.id.password);
		et2 = (EditText)findViewById(R.id.repassword);
		ph =  (EditText)findViewById(R.id.phone);
		reg = (Button)findViewById(R.id.register);
		
		reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String text1 = et.getText().toString();
				String text2 = et1.getText().toString();
				String text3 = et2.getText().toString();
				String text4 = ph.getText().toString();
				
				if(text1.equals("")||text2.equals("")||text3.equals("")||text4.equals(""))
				{
					Toast.makeText(MainActivity.this, "some field is empty", Toast.LENGTH_SHORT).show();
				}
				else
				{
					if(text2.equals(text3))
					{
						SharedPreferences settings = getSharedPreferences("prefs", 0);
						SharedPreferences.Editor editor = settings.edit();
						editor.putString("usernamae",text1);
						editor.putString("password", text2);
						editor.putString("phone",text4);
						editor.commit();
						Intent cre = new Intent(getApplicationContext(),Login.class);
						startActivity(cre);
						finish();
					}
					else
					{
						Toast.makeText(MainActivity.this, "passwords doenst match !", Toast.LENGTH_SHORT).show();
					}
				}
				
			}
		});
				
	}
	}