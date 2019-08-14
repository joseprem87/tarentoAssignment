package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.config.JsonConfig;
import com.example.demo.model.ListOfRating;
import com.example.demo.model.Ratings;
import com.example.demo.model.ResponseData;

@Service
public class JsonReaderServiceImpl implements JsonReaderService {

	public List<ResponseData> getData() throws IOException {
		Map<String, List<Ratings>> finalMap = new HashMap<>();
		Map<String, ListOfRating> map = JsonConfig.myMap;
		ListOfRating list = map.get("data");

		list.getRatings().forEach(i -> {

			if (finalMap.containsKey(i.getOutletCode())) {
				Ratings r = new Ratings();
				r.setRating(i.getRating());

				List<Ratings> rs = finalMap.get(i.getOutletCode());
				if (rs.contains(r)) {
					Ratings rating = rs.get(rs.indexOf(r));
					//r.setCount(rating.getCount().intValue() + 1);
					rating.setCount(rating.getCount().intValue() + 1);
					rs.set(rs.indexOf(r), rating);
				}else {
				rs.add(r);
				}

			} else {
				Ratings r = new Ratings();
				List<Ratings> finalList = new ArrayList<>();
				r.setRating(i.getRating());
				finalList.add(r);

				finalMap.put(i.getOutletCode(), finalList);

			}

		});
		System.out.println("Map in servicee" + finalMap);
		return buildingFinalResponse(finalMap);

	}

	private List<ResponseData> buildingFinalResponse(Map<String, List<Ratings>> finalMap) {

		List<ResponseData> responseList = new ArrayList<>();

		finalMap.entrySet().forEach(i -> {
			ResponseData rs = new ResponseData();
			rs.setOutletCode(i.getKey());
			Set<Ratings> ratings = rs.getRatings();
			ratings.removeAll(i.getValue());
			ratings.addAll(i.getValue());
			rs.setRatings(ratings);
			responseList.add(rs);

		});
		return responseList;

	}

}
