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

	private static LatLng hackerspaceLocation;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}



	@Override
	public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
	    View v = super.onCreateView(arg0, arg1, arg2);
	    initMap();
	    return v;
	}


	private void initMap(){
		
		hackerspaceLocation = new LatLng(40.993498, 29.042059);
		CameraPosition cameraPosition = new CameraPosition.Builder()
	    .target(hackerspaceLocation)      // Sets the center of the map to Mountain View
	    .zoom(16)                   // Sets the zoom
	    .build(); 
		
		CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
		
		getMap().moveCamera(update);
		
		this.addMarker(getMap());
	    
	}
	
	private void addMarker(GoogleMap map) {
		if (map != null) {
			MarkerOptions options = new MarkerOptions();
			options.position(hackerspaceLocation);
			map.addMarker(options);
			
			map.setMyLocationEnabled(true);
			
		} else {
			Log.e("hs","Map object is null");
		}
	}

}
