package org.istanbulhs.istanbulhsapp.fragments;

import org.istanbulhs.istanbulhsapp.R;
import org.istanbulhs.istanbulhsapp.data.Post;
import org.istanbulhs.istanbulhsapp.utils.HttpUtil;
import org.istanbulhs.istanbulhsapp.utils.JSONParser;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
		
		Button saveButton = (Button)view.findViewById(R.id.saveButton);
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				saveName();
			}
		});
		
		
		return view;
	}

	private void saveName() {
		EditText editText = (EditText)getActivity().findViewById(R.id.editText1);
		String name = editText.getText().toString();
		
		SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("name", name);
		editor.commit();
		Toast toast = Toast.makeText(getActivity(), "Kaydedildi", Toast.LENGTH_SHORT);
		toast.show();
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}
	
	private class LatestNewsAsyncTask extends AsyncTask<Void, Void, Post> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected Post doInBackground(Void... arg0) {
			String result = this.retrieveLatestNews();
			Post post = JSONParser.parseStringToMap(result);
			
			String url = "http://hamdi.safkanyazilim.com" + post.getLargePhotoUrl();
			Drawable photo = HttpUtil.loadImageFromWeb(url);
			post.setLargePhoto(photo);
			return post;
		}

		@Override
		protected void onPostExecute(Post post) {
			if (post!=null) {
				
				
				if (getActivity() != null) {
					TextView titleTextView = (TextView)getActivity().findViewById(R.id.post_title);
					titleTextView.setText(post.getTitle());
					
					TextView textTextView = (TextView)getActivity().findViewById(R.id.post_text);
					textTextView.setText(post.getText());
					
					ImageView imageView = (ImageView)getActivity().findViewById(R.id.post_image);
					imageView.setImageDrawable(post.getLargePhoto());
				}
			}
		}

		private String retrieveLatestNews() {
			String url = "http://hamdi.safkanyazilim.com/json/latest-post";
			String response = HttpUtil.getResponseStringForHttpRequestBetter(url);
			Log.i("hs", response);
			
			return response;
		}

	}


}
