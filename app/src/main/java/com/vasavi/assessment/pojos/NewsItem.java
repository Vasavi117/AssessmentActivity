package com.vasavi.assessment.pojos;

import com.google.gson.annotations.SerializedName;

public class NewsItem{

	@SerializedName("image")
	private String image;

	@SerializedName("source_country")
	private String sourceCountry;

	@SerializedName("author")
	private String author;

	@SerializedName("language")
	private String language;

	@SerializedName("id")
	private int id;

	@SerializedName("text")
	private String text;

	@SerializedName("title")
	private String title;

	@SerializedName("publish_date")
	private String publishDate;

	@SerializedName("url")
	private String url;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setSourceCountry(String sourceCountry){
		this.sourceCountry = sourceCountry;
	}

	public String getSourceCountry(){
		return sourceCountry;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPublishDate(String publishDate){
		this.publishDate = publishDate;
	}

	public String getPublishDate(){
		return publishDate;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}