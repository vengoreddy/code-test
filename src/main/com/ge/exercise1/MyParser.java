package com.ge.exercise1;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyParser implements Parser {

	@Override
	public Application parseApplicationData(String data) {
		
		Application application = null;
		try {
			// Convert the structured text to JSON string and 
			// use the ObjectMapper to construct the application object.
			String dataJson = this.convertToJsonString(data);
			ObjectMapper objectMapper = new ObjectMapper();
			application = objectMapper.readValue(dataJson, ApplicationImpl.class);
			
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return application;		
	}
	
	private String convertToJsonString(String data) {
		
		String dataJson = data.replaceAll("Application", "");
		dataJson = dataJson.replace('(', '{');
		dataJson = dataJson.replace(')', '}');
		dataJson = dataJson.replace("id", "\"id\"");
		dataJson = dataJson.replace("name", "\"name\"");
		dataJson = dataJson.replace("users", "\"users\"");
		dataJson = dataJson.replace("groups", "\"groups\"");
		dataJson = dataJson.replace(": ", ": \"");
		dataJson = dataJson.replace(",", "\",");
		dataJson = dataJson.replace("}", "\"}");
		dataJson = dataJson.replace("User{", "{");
		dataJson = dataJson.replace("Group{", "{");		
		dataJson = dataJson.replace("]\"", "]");
		dataJson = dataJson.replace("}\"", "}");
		System.out.println(dataJson);
		
		return dataJson;
		
	}

}
