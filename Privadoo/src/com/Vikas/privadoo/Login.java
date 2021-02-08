package com.Vikas.privadoo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	EditText tuser;
	EditText tpass;
	Button login;
	String registereduser;
	String registeredpassword;
	String phone;
	int i=3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		SharedPreferences settings = getSharedPreferences("prefs",0);
		registereduser = settings.getString("username","");
		registeredpassword = settings.getString("password", "");
		phone=settings.getString("phone","");
		
		tuser=(EditText)findViewById(R.id.username1);
		tpass=(EditText)findViewById(R.id.password1);
	    login=(Button)findViewById(R.id.login);
	    
	    login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String text1 = tuser.getText().toString();
				String text2 = tpass.getText().toString();
				
				SharedPreferences settings = getSharedPreferences("prefs",0);
				registereduser = settings.getString("username","");
				registeredpassword = settings.getString("password", "");
				
				
				if(text2.equals(registeredpassword)&&text1.equals(registereduser))
				{
					Intent i = new Intent(Login.this,Home.class);
					startActivity(i);
					finish();
				}
				else if(i>0)
				{
					i=i-1;
					Toast.makeText(Login.this,text2 +" "+registeredpassword+" Invalid credentials "+ registereduser +" " + text1,Toast.LENGTH_SHORT).show();
				}
				else
				{
					@SuppressWarnings("unused")
					SmsManager sms = SmsManager.getDefault();
					sms.sendTextMessage(phone,null, "someday entered incorrect password three times . Pleasse chesck your mobile", null,null);
					
				}
				
				
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

}
