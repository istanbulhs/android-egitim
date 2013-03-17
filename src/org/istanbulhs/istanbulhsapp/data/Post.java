package org.istanbulhs.istanbulhsapp.data;

import java.util.Date;

import android.graphics.drawable.Drawable;

//Request'ten donen stringi bu data objesine ceviriyoruz
public class Post {
	private int id;
	private Date sentDate;
	private String title;
	private String text;
	private String largePhotoUrl;
	private Drawable largePhoto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLargePhotoUrl() {
		return largePhotoUrl;
	}
	public void setLargePhotoUrl(String largePhotoUrl) {
		this.largePhotoUrl = largePhotoUrl;
	}
	public Drawable getLargePhoto() {
		return largePhoto;
	}
	public void setLargePhoto(Drawable largePhoto) {
		this.largePhoto = largePhoto;
	}

}


