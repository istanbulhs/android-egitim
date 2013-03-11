package org.istanbulhs.istanbulhsapp.asynctasks;


import org.istanbulhs.istanbulhsapp.utils.HttpUtil;

import android.os.AsyncTask;
import android.util.Log;

//UI'in calistigi ana thread'den calismamasi gereken metodlari ayri thread'den calistiriliyor
//Internet uzerinden servis cagirma gibi uzun surebilecek isler ancak ayri bir threadden yapilabiliyor
//AsyncTask, ayri thread'den calisacak metodlar icin yapilmis bir class
//<Void, Void, String> Koseli parantezden birincisi olan Void doInBackground metodunun arguman tipi
//Ikincisi Void onProgressUpdate'in arguman tipi, Ucuncusu String ise onPostExecute'in argumani
//Ayri threadden calisan metod doInBackground
public class LatestNewsAsyncTask extends AsyncTask<Void, Void, String> {

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected String doInBackground(Void... arg0) {
		this.retrieveLatestNews();
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}

	
	private String retrieveLatestNews() {
		String url = "http://hamdi.safkanyazilim.com/json/latest";
		String response = HttpUtil.getResponseStringForHttpRequestBetter(url);
		Log.i("hs", response);
		
		return response;
	}

}
