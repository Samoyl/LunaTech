package com.samoyl.entities;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Countries {

	private int id;
	private String code;
	private String name;
	private String countinent;
	private String wikipedia_link;
	private String keywords;
	private List<Airports> airports;
	private int airportCount;

	public Countries() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountinent() {
		return countinent;
	}

	public void setCountinent(String countinent) {
		this.countinent = countinent;
	}

	public String getWikipedia_link() {
		return wikipedia_link;
	}

	public void setWikipedia_link(String wikipedia_link) {
		this.wikipedia_link = wikipedia_link;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<Airports> getAirports() {
		return airports;
	}

	public void setAirports(List<Airports> airports) {
		this.airports = airports;
	}

	public int getAirportCount() {
		return airportCount;
	}

	public void setAirportCount(int airportCount) {
		this.airportCount = airportCount;
	}
}
