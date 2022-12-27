package com.vasavi.assessment.pojos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FeedResponse{

	@SerializedName("news")
	private List<NewsItem> news;

	@SerializedName("number")
	private int number;

	@SerializedName("offset")
	private int offset;

	@SerializedName("available")
	private int available;

	public void setNews(List<NewsItem> news){
		this.news = news;
	}

	public List<NewsItem> getNews(){
		return news;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setAvailable(int available){
		this.available = available;
	}

	public int getAvailable(){
		return available;
	}
}