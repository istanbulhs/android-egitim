package org.istanbulhs.istanbulhsapp.utils;

import org.istanbulhs.istanbulhsapp.data.Post;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {
	
	//Bu methodlar request'ten donen string'i alip Post data objesine ceviriyoruz
	public static Post parseStringToMap(String str) {
		Post post = new Post();
		
		try {
			JSONObject obj = new JSONObject(str);
			post.setId(obj.getInt("id"));
			post.setTitle(obj.getString("title"));
			post.setText(obj.getString("text"));
			post.setLargePhotoUrl(obj.getString("large_photo_url"));
		} catch (JSONException e) {
			Log.e("hs", e.getMessage());
			post = null;
		}
		
		return post;
	}

}
