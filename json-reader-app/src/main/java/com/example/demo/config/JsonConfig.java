package com.example.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.ListOfRating;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 
 * this class is used for loading data from Json File
 * 
 *
 */

@Configuration
public class JsonConfig {
	
	//map for storing data
	public static Map<String, ListOfRating> myMap;

	@Bean
	public static void fetchProperties() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<ListOfRating> typeReference = new TypeReference<ListOfRating>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/InputJson.json");
		ListOfRating ratings = mapper.readValue(inputStream, typeReference);

		System.out.println(" ratings ......." + ratings);
		ratings.getRatings().forEach(i -> {
			System.out.println("rating " + i.getRating() + "  Time Of Rating  " + i.getTimeOfRating());
		});
		loadData(ratings);

	}

	public static void loadData(ListOfRating ratings) {

		Map<String, ListOfRating> finalMap = new HashMap<>();
		finalMap.put("data", ratings);

		myMap = Collections.unmodifiableMap(finalMap);

	}
}
