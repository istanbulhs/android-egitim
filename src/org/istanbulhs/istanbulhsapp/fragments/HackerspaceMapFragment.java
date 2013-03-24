package org.istanbulhs.istanbulhsapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HackerspaceMapFragment extends SupportMapFragment {
	
	@Override
	public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
	    View v = super.onCreateView(arg0, arg1, arg2);
	    this.initMap();
	    return v;
	}


	private void initMap(){
		//Haritanin orta noktasini Hackerspace'e ayarliyoruz
		//Hackerspace'in lokasyonu
		LatLng hackerspaceLocation = new LatLng(40.993498, 29.042059);
		CameraPosition cameraPosition = new CameraPosition.Builder()
	    												  .target(hackerspaceLocation)      // Sets the center of the map to Mountain View
	    												  .zoom(16)  // Zoom'u ayarlar
	    												  .build(); 
		
		CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
		getMap().moveCamera(update);
		
		//kendi yerimizi ve hackerspace'in yerini iþaretliyoruz
		this.addMarker(getMap(), hackerspaceLocation);
	    
	}
	
	private void addMarker(GoogleMap map, LatLng hackerspaceLocation) {
		if (map != null) {
			//Hackerspace'in oldugu yerde kirmizi bir balon cikarmak icin
			MarkerOptions options = new MarkerOptions();
			options.position(hackerspaceLocation);
			map.addMarker(options);
			
			//Haritada kendi lokasyonumuzu gormek icin
			map.setMyLocationEnabled(true);
			
		} else {
			//map objesi null ise log atiyoruz
			Log.e("hs","Map object is null");
		}
	}

}
