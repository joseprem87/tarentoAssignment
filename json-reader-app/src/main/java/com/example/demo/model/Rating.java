package com.example.demo.model;

public class Rating {


	private String timeOfRating;
	private String dateOfRating;
	private Integer rating;
	private String outletCode;

	public String getTimeOfRating() {
		return timeOfRating;
	}

	public void setTimeOfRating(String timeOfRating) {
		this.timeOfRating = timeOfRating;
	}

	public String getDateOfRating() {
		return dateOfRating;
	}

	public void setDateOfRating(String dateOfRating) {
		this.dateOfRating = dateOfRating;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getOutletCode() {
		return outletCode;
	}

	public void setOutletCode(String outletCode) {
		this.outletCode = outletCode;
	}

}
