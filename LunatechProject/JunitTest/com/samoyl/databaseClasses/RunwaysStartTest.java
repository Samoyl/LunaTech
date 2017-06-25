package com.samoyl.databaseClasses;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.samoyl.entities.Runways;

public class RunwaysStartTest {

	private RunwaysStart runwaysStart;
	private List<Runways> runwayList;

	@Before
	public void setUp() throws Exception {
		runwaysStart = new RunwaysStart();
		runwayList = new ArrayList<Runways>();
	}

	@Test
	public void testGetAllRunways() {
		runwayList = runwaysStart.getAllRunways();
		assertNotNull(runwayList);
	}

}
