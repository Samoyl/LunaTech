package com.samoyl.services;

import com.samoyl.entities.Countries;
import com.samoyl.main.Start;

public class SearchDAO {
	
	public Countries searchCounteries(String input) {
		Countries country = new Countries();
		for (Countries item : Start.countries) {
			if (item.getName().toLowerCase().equals(input.toLowerCase())) {
				country = item;
			} else if (item.getCode().toLowerCase().equals(input.toLowerCase())) {
				country = item;
			}
		}
		return country;
	}
}
