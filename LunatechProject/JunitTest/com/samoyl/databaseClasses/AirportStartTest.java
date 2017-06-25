package com.samoyl.databaseClasses;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.samoyl.entities.Airports;

public class AirportStartTest {

	private AirportStart airportStart;
	private List<Airports> ariportList;
	

	@Before
	public void setUp() throws Exception {
		airportStart = new AirportStart();
		ariportList = new ArrayList<Airports>();
	}

	@Test
	public void testGetAirports() {
		ariportList = airportStart.getAirports();
		assertNotNull(ariportList);
	}

}
