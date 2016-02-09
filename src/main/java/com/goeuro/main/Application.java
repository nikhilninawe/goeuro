package com.goeuro.main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.goeuro.model.City;
import com.google.gson.Gson;

public class Application {

	private static final String queryUrl = "http://api.goeuro.com/api/v2/position/suggest/en/%s";

	/** Description  Main method for the application
	 * 
	 */
	public static void main(String[] args) throws IOException{
		String queryUrlWithCity = String.format(queryUrl, args[0]);
		String data = getDataFromUrl(queryUrlWithCity);
		List<String[]> csvData = getDataAsListOfString(data);
		writeDataListToFile(csvData);
		System.out.println("Data available in data.csv");
	}

	/** Description 	 Converts a given string which is json array of city to list of string array
	 *	@param data  	 String representing json array of city 
	 * 	@return          List of String array where String array contains attributes of a city
	 */
	public static List<String[]> getDataAsListOfString(String data){
		List<String[]> csvData = new ArrayList<String[]>();
		Gson gson = new Gson();
		City[] cityList = gson.fromJson(data, City[].class);
		for(City cityObject : cityList){
			String[] cityData = cityObject.getDataForCsv();
			csvData.add(cityData);
		}
		return csvData;
	}

	/**	Description 	 Writes List of String array to file data.csv using opencsv
	 *  @param csvData   List of String array where String array contains attributes of a city
	 *  @return          void
	 */
	public static void writeDataListToFile(List<String[]> csvData) throws IOException{
		CSVWriter writer = new CSVWriter(new FileWriter("data.csv"), ',');
		writer.writeNext("_id,name,type,latitude,longitude".split(","));
		writer.writeAll(csvData);
		writer.close();
	}

	/** Description Fetches data from a url in String format 
	 *  @param url  URL to fetch
	 *  @return     Data in the URL in String format
	 */
	public static String getDataFromUrl(String url) throws IOException{
		URL goEuro = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(goEuro.openStream()));
		StringBuilder sb = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();
		return sb.toString();
	}
}
