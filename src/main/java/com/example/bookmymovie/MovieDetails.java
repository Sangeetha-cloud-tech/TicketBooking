package com.example.bookmymovie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MovieDetails 
{
	@Id
	private int num;
	public MovieDetails() {
		super();
	}
	public MovieDetails(int num, String title, String genre, String duration, String rating) {
		super();
		this.num = num;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	private String title;
	private String genre;
	private String duration;
	private String rating;


}
