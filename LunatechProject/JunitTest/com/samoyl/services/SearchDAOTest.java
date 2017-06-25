package com.samoyl.services;

import static org.junit.Assert.*;

import org.junit.*;

import com.samoyl.entities.Countries;

public class SearchDAOTest {

	private SearchDAO search;
	

	@Before
	public void setUp() throws Exception {
		search = new SearchDAO();
	}

	@Test
	public void testSearchCounteries() {
		String input = "Sweden";
		Countries countery = search.searchCounteries(input);
		assertEquals("SE", countery.getCode());
	}

}
