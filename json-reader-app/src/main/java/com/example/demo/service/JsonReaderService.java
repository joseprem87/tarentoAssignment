package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.ResponseData;

public interface JsonReaderService {
	abstract List<ResponseData> getData() throws IOException; 

}
