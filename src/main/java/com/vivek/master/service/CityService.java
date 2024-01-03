package com.vivek.master.service;

import java.sql.SQLException;
import java.util.List;

import com.vivek.master.model.City;

public interface CityService {

	List<City> getallCities() throws SQLException;
	
	public int addCity(City city) throws SQLException;
	
	public int updatecity(City city) throws SQLException;
	
	public City fetchbyId(int id) throws SQLException;
	

}
