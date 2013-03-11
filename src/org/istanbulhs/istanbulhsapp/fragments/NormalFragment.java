package org.istanbulhs.istanbulhsapp.fragments;

import org.istanbulhs.istanbulhsapp.R;
import org.istanbulhs.istanbulhsapp.asynctasks.LatestNewsAsyncTask;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Activities that
 * contain this fragment must implement the
 * {@link NormalFragment.OnFragmentInteractionListener} interface to handle
 * interaction events. Use the {@link NormalFragment#newInstance} factory method
 * to create an instance of this fragment.
 * 
 */
public class NormalFragment extends Fragment {

	public NormalFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
		}
		
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_normal, container, false);
		
		Button button = (Button)view.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("hs", "Button kliklendi");
				LatestNewsAsyncTask task = new LatestNewsAsyncTask();
				task.execute();
			}
		});
		
		
		return view;
	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

}
