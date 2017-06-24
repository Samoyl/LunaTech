package com.samoyl.main;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.codoid.products.exception.FilloException;
import com.samoyl.databaseClasses.CountriesStart;
import com.samoyl.entities.Airports;
import com.samoyl.entities.Countries;
import com.samoyl.services.RaportDAO;
import com.samoyl.services.SearchDAO;

@ManagedBean
@RequestScoped
public class Start implements Serializable {

	private static final long serialVersionUID = 1L;
	public static List<Countries> countries;
	static CountriesStart countryStart;
	private Countries country;
	private List<Airports> listOfAirports;
	private List<Countries> first10Counteries, last10Counteries;
	private String name;
	SearchDAO search;
	RaportDAO raport;
	static {
		countryStart = new CountriesStart();
		try {
			try {
				countries = countryStart.getAllCountries();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Collections.sort(countries, new Comparator<Countries>() {
				public int compare(Countries country1, Countries country2) {
					return Integer.valueOf(country2.getAirportCount()).compareTo(country1.getAirportCount());
				}
			});
		} catch (FilloException e) {
			e.printStackTrace();
		}
	}
	
	public Start() {
		country = new Countries();
		search = new SearchDAO();
		raport = new RaportDAO();
	}

	public void searchCountery(String input){
		country = search.searchCounteries(input);
		listOfAirports = country.getAirports();
		setName(country.getName());
	}
	
	public void raport(){
		first10Counteries = raport.first10Counteies(countries);
		last10Counteries = raport.last10Counteies(countries);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Airports> getListOfAirports() {
		return listOfAirports;
	}

	public Countries getCountry() {
		return country;
	}

	public List<Countries> getFirst10Counteries() {
		return first10Counteries;
	}

	public List<Countries> getLast10Counteries() {
		return last10Counteries;
	}

}
