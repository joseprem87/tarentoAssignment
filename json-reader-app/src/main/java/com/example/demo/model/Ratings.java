package com.example.demo.model;

public class Ratings {
	

	private Integer rating;
	private Integer count;
	
	
	public Ratings() {
		super();
		this.count = 1;
	}
	
	public Ratings(Integer rating) {
		super();
		this.rating = rating;
		this.count = 0;
	}

	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ratings other = (Ratings) obj;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}

	
}
