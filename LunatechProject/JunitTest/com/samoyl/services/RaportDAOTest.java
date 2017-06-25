package com.samoyl.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import com.samoyl.entities.Countries;
import com.samoyl.main.Start;

public class RaportDAOTest {

	private List<Countries> counterList;
	private RaportDAO raport;

	@Before
	public void setUp() throws Exception {
		raport = new RaportDAO();
		counterList = new ArrayList<>();
	}

	@Test
	public void testFirst10Counteies() {
		counterList = raport.first10Counteies(Start.countries);
		assertNotNull(counterList);
	}

	@Test
	public void testLast10Counteies() {
		counterList = raport.last10Counteies(Start.countries);
		assertNotNull(counterList);
	}

}
