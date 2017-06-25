package com.samoyl.databaseClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.samoyl.entities.Airports;
import com.samoyl.entities.Runways;

public class AirportStart {

	public AirportStart() {

		
	}

	public List<Airports> getAirports() {
		RunwaysStart runway = new RunwaysStart();
		List<Runways> runways = runway.getAllRunways();

		Fillo fillo = new Fillo();
		Connection connection;
		Airports airport;
		List<Airports> airports = new ArrayList<Airports>();

		try {
			
			connection = fillo.getConnection("C:\\Users\\samoy\\git\\LocalLunatech\\LunatechProject\\Database\\airports.xlsx");
			String queryStr = "Select * from airports";
			Recordset recordset = connection.executeQuery(queryStr);
			while (recordset.next()) {
				airport = new Airports();
				airport.setId(Integer.parseInt(recordset.getField("id")));
				airport.setIdent(recordset.getField("ident"));
				airport.setType(recordset.getField("type"));
				airport.setName(recordset.getField("name"));
				airport.setLatitude_deg(recordset.getField("latitude_deg"));
				airport.setLongitude_deg(recordset.getField("longitude_deg"));
				airport.setElevation_ft(recordset.getField("elevation_ft"));
				airport.setContinent(recordset.getField("continent"));
				airport.setIso_country(recordset.getField("iso_country"));
				airport.setIso_region(recordset.getField("iso_region"));
				airport.setMunicipality(recordset.getField("municipality"));
				airport.setScheduled_service(recordset.getField("scheduled_service"));
				airport.setGps_code(recordset.getField("gps_code"));
				airport.setIata_code(recordset.getField("iata_code"));
				airport.setLocal_code(recordset.getField("local_code"));
				airport.setHome_link(recordset.getField("home_link"));
				airport.setWikipedia_link(recordset.getField("wikipedia_link"));
				airport.setKeywords(recordset.getField("keywords"));
				String airportCode = airport.getIdent();
				Runways[] run = runways.stream().filter(r -> r.getAirport_ident().equals(airportCode))
						.toArray(Runways[]::new);
				airport.setRunways(Arrays.asList(run));
				airports.add(airport);
			}
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		}

		return airports;
	}
}
