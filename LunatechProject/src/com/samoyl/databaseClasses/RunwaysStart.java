package com.samoyl.databaseClasses;

import java.util.ArrayList;
import java.util.List;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.samoyl.entities.Runways;

public class RunwaysStart {

	public List<Runways> getAllRunways() {
		List<Runways> runways = new ArrayList<>();
		Runways runway;
		Fillo fillo = new Fillo();
		Connection connection;
		try {
			connection = fillo.getConnection("C:\\Users\\samoy\\git\\LocalLunatech\\LunatechProject\\Database\\runways.xlsx");
			Recordset recordset = connection.executeQuery("Select * from runways");
			while (recordset.next()) {
				runway = new Runways();
				runway.setId(Integer.parseInt(recordset.getField("id")));
				runway.setAirport_ref(recordset.getField("airport_ref"));
				runway.setAirport_ident(recordset.getField("airport_ident"));
				runway.setLength_ft(recordset.getField("length_ft"));
				runway.setWidth_ft(recordset.getField("width_ft"));
				runway.setSurface(recordset.getField("surface"));
				runway.setLighted(recordset.getField("lighted"));
				runway.setClosed(recordset.getField("closed"));
				runway.setLe_ident(recordset.getField("le_ident"));
				runway.setLe_latitude_deg(recordset.getField("le_latitude_deg"));
				runway.setLe_longitude_deg(recordset.getField("le_longitude_deg"));
				runway.setLe_elevation_ft(recordset.getField("le_elevation_ft"));
				runway.setLe_heading_deg(recordset.getField("le_heading_degT"));
				runway.setLe_displaced_threshold_ft(recordset.getField("le_displaced_threshold_ft"));
				runway.setHe_ident(recordset.getField("he_ident"));
				runway.setHe_latitude_deg(recordset.getField("he_latitude_deg"));
				runway.setHe_longitude_deg(recordset.getField("he_longitude_deg"));
				runway.setHe_elevation_ft(recordset.getField("he_elevation_ft"));
				runway.setHe_heading_degT(recordset.getField("he_heading_degT"));
				runway.setHe_displaced_threshold_ft(recordset.getField("he_displaced_threshold_ft"));
				runways.add(runway);
			}
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		}
		
		return runways;
	}

}
