package org.istanbulhs.istanbulhsapp;

import android.os.Bundle;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
//import android.widget.Toast;

//Diger Activity'lerden farkli olarak bunu ListActivity'nin cocugu olarak tanimliyoruz
public class PersonListActivity extends ListActivity {

	private String[] emailList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_list);
		
		//strings.xml'deki icerigi okumak icin asagidaki objeyi aliyoruz
		Resources resources = getResources();
		
		//Bunu kullanarak kisi isimlerinin durdugu string-array'imizi okuyoruz
		String[] personNameList = resources.getStringArray(R.array.person_name_list);
		//Gene ayni sekilde email listesini de okuyoruz
		emailList = resources.getStringArray(R.array.person_email_list);
		
		//Asagida bir list adapter yaratiyoruz. Bu list adapter array icindeki isim listesini arayuzde gostermek icin adapte ediyor
		ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.person_list_item, personNameList);
		//Bu listAdapter'i aktivitemize veriyoruz
		setListAdapter(listAdapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//Listede bir satir tiklandiginda cagirilan metod
		//Asagidaki satir listede bir satir tiklandiginda kisa bir sure gozuken emaili gosteren bir kutucuk olusturuyor
		//Gozukmesi icin asagidaki iki satirin comment olmaktan cikarmaniz gerekiyor
		//Toast toast = Toast.makeText(this, emailList[position], Toast.LENGTH_SHORT);
		//toast.show();
		
		//Asagidaki kod emaili gosteren ustunde ok butonu olan bir uyari kutucugu yaratan objeyi yaratiyor
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(emailList[position])
				.setTitle("Eposta")
				.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						
					}
				});
		
		//Asagidaki kod kutucugu yaratiyor arkasindan da ekranda gosteriyor
		AlertDialog dialog = builder.create();
		dialog.show();
		
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person_list, menu);
		return true;
	}

}
