package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RatingResponse;
import com.example.demo.model.ResponseData;
import com.example.demo.model.StatusInfo;
import com.example.demo.service.JsonReaderService;

@RestController
@RequestMapping(value = "/rating")
public class JsonReaderController {

	@Autowired
	JsonReaderService service;

	@GetMapping(value = "/getRating")
	public ResponseEntity<RatingResponse> getData() {
		RatingResponse ratingResponse = new RatingResponse();

		List<ResponseData> jsonResponse = null;
		try {
			jsonResponse = service.getData();
			if (jsonResponse != null) {
				StatusInfo info = new StatusInfo();
				info.setErrorMessage("");
				info.setStatusCode("200");
				info.setStatusMessage("success");

				ratingResponse.setReponseData(jsonResponse);
				ratingResponse.setStatusInfo(info);

			} 
		} catch (IOException e) {
			StatusInfo info = new StatusInfo();
			info.setErrorMessage(e.getMessage());
			info.setStatusCode("500");
			info.setStatusMessage("error occured in parsing json");
			ratingResponse.setStatusInfo(info);
			
		
		}

		System.out.println("Response" + ratingResponse);
		return new ResponseEntity<RatingResponse>(ratingResponse, HttpStatus.OK);

	}

}
