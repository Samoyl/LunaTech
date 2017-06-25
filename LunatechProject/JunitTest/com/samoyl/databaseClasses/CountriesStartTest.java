package com.samoyl.databaseClasses;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.codoid.products.exception.FilloException;
import com.samoyl.entities.Countries;

public class CountriesStartTest {

	private CountriesStart countriesStart;

	@Before
	public void setUp() throws Exception {
		countriesStart = new CountriesStart();
	}

	@Test
	public void testGetAllCountries() throws FilloException, IOException {
		List<Countries> countries = countriesStart.getAllCountries();
		assertNotNull(countries);
	}

}
