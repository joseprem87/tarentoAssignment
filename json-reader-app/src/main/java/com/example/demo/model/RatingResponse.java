package com.example.demo.model;

import java.util.List;

public class RatingResponse {
	
	private StatusInfo statusInfo;
	private List<ResponseData> reponseData;

    public StatusInfo getStatusInfo() {
		return statusInfo;
	}


	public void setStatusInfo(StatusInfo statusInfo) {
		this.statusInfo = statusInfo;
	}


	public List<ResponseData> getReponseData() {
		return reponseData;
	}


	public void setReponseData(List<ResponseData> reponseData) {
		this.reponseData = reponseData;
	}






	

}
