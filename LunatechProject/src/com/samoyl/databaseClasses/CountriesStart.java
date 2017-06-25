package com.samoyl.databaseClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.samoyl.entities.Airports;
import com.samoyl.entities.Countries;

public class CountriesStart {

	public List<Countries> getAllCountries() throws FilloException {

		AirportStart airport = new AirportStart();
		List<Airports> airports = airport.getAirports();
		Fillo fillo = new Fillo();
		Connection connection;
		connection = fillo
				.getConnection("C:\\Users\\samoy\\git\\LocalLunatech\\LunatechProject\\Database\\countries.xlsx");
		// connection = fillo.getConnection(path);
		Recordset recordset = connection.executeQuery("Select * from countries");
		List<Countries> countries = new ArrayList<Countries>();
		Countries country;
		while (recordset.next()) {
			country = new Countries();
			country.setId(Integer.parseInt(recordset.getField("id")));
			country.setCode(recordset.getField("code"));
			country.setName(recordset.getField("name"));
			country.setCountinent(recordset.getField("continent"));
			country.setWikipedia_link(recordset.getField("Wikipedia_link"));
			country.setKeywords(recordset.getField("keywords"));
			String code = country.getCode();
			Airports[] ListOfairport = airports.stream().filter(f -> f.getIso_country().equals(code))
					.toArray(Airports[]::new);
			country.setAirports(Arrays.asList(ListOfairport));
			country.setAirportCount(country.getAirports().size());
			countries.add(country);
		}
		connection.close();
		recordset.close();
		return countries;
	}

}
