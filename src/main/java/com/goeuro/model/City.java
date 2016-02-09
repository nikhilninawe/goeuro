package com.goeuro.model;

import java.util.ArrayList;

public class City {
	
	private Long _id;
	private String key;
	private String name;
	private String fullName;
	private String iata_airport_code;
	private String type;
	private String country;
	private Long location_id;
	private Boolean inEurope;
	private String countryCode;
	private Boolean coreCountry;
	private Double distance;
	private GeoPosition geo_position;
	
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIata_airport_code() {
		return iata_airport_code;
	}
	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}
	public Boolean getInEurope() {
		return inEurope;
	}
	public void setInEurope(Boolean inEurope) {
		this.inEurope = inEurope;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Boolean getCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(Boolean coreCountry) {
		this.coreCountry = coreCountry;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public String[] getDataForCsv(){
		ArrayList<String> data = new ArrayList<String>();
		data.add(this._id.toString());
		data.add(this.name);
		data.add(this.type);
		data.add(this.geo_position.getLatitude().toString());
		data.add(this.geo_position.getLongitude().toString());
		String[] result = new String[5];
		return data.toArray(result);
	}
	
	@Override
	public String toString() {
		return "City [_id=" + _id + ", key=" + key + ", name=" + name
				+ ", fullName=" + fullName + ", iata_airport_code="
				+ iata_airport_code + ", type=" + type + ", country=" + country
				+ ", location_id=" + location_id + ", inEurope=" + inEurope
				+ ", countryCode=" + countryCode + ", coreCountry="
				+ coreCountry + ", distance=" + distance + ", geo_position="
				+ geo_position + "]";
	}
	public GeoPosition getGeo_position() {
		return geo_position;
	}
	public void setGeo_position(GeoPosition geo_position) {
		this.geo_position = geo_position;
	}

}
