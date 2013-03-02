package org.istanbulhs.istanbulhsapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//xml'deki arayuz tanimlari yukleniyor
		setContentView(R.layout.activity_start);
	}
	
	
	public void startGameActivity(View sender) {
		//Butona tiklandiginda cagirilan metod
		//Sayi oyunu aktivitesi yaratiliyor
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void startPersonListActivity(View sender) {
		//Butona tiklandiginda cagirilan metod
		//Kisi listesi aktivitesi yaratiliyor
		Intent intent = new Intent(this, PersonListActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
