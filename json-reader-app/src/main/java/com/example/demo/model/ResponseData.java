package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

public class ResponseData {
	private String outletCode;
	private Set<Ratings>ratings;
	
//default object 
	public ResponseData() {
		super();
		ratings = new HashSet<>();
		ratings.add(new Ratings(1));
		ratings.add(new Ratings(2));
		ratings.add(new Ratings(3));
		ratings.add(new Ratings(4));
		ratings.add(new Ratings(5));
	}

	public String getOutletCode() {
		return outletCode;
	}

	public void setOutletCode(String outletCode) {
		this.outletCode = outletCode;
	}

	public Set<Ratings> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Ratings> set) {
		this.ratings = set;
	}

	



}
