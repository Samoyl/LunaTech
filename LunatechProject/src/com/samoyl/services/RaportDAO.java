package com.samoyl.services;

import java.util.ArrayList;
import java.util.List;

import com.samoyl.entities.Countries;


public class RaportDAO {
	
	public List<Countries> first10Counteies(List<Countries> countries) {
		List<Countries> first10Counteries = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			first10Counteries.add(countries.get(i));
		}
		return first10Counteries;
	}
	
	public List<Countries> last10Counteies(List<Countries> countries) {
		List<Countries> last10Counteries = new ArrayList<>();
		
		for (int i = countries.size(); i > (countries.size() - 10); i--) {
			last10Counteries.add(countries.get(i - 1));
		}
		return last10Counteries;
	}
}
