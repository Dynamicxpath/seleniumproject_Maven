package com.crm.autodesk.GenericLibraries;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/*
 * 
 * this class contains methods to read data from json file
 * @girija
 * 
 */
public class Jsonutility {
	/* this method reads the data from json file */
	
	public String readDATAFromJSON(String key) throws Throwable
	{
		// read the data from json file
		
		FileReader file = new FileReader(IPathConstants.JsonFilePath);
		// convert the json file into java object
		JSONParser jp= new JSONParser();
		Object jo= jp.parse(file);
		
		// type cast java to hashmap
		
		HashMap map = (HashMap)jo;
		
		String value= map.get(key).toString();
		// return the value
		
		return value;
		
	}

}
