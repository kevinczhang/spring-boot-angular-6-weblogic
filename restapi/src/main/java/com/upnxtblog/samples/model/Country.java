package com.upnxtblog.samples.model;

public class Country {

	String name;
	String capital;
	String region;
	
	public Country() {}
	
	public Country(String name, String capital, String region) {
		this.name = name;
		this.capital = capital;
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
