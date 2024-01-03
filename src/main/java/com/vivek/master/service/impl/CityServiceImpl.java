package com.vivek.master.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vivek.dbcon.ConnectionProvider;
import com.vivek.master.dao.CityDAO;
import com.vivek.master.dao.jdbcdao.JDBCCityDAO;
import com.vivek.master.model.City;
import com.vivek.master.service.CityService;

public class CityServiceImpl implements CityService {
	
	@Override
	public List<City> getallCities() throws SQLException{
		List<City> citylist = new ArrayList<City>();
		
		//dependency injection:
		CityDAO cityDAO = new JDBCCityDAO(ConnectionProvider.getConnection());
		citylist = cityDAO.findAll();
		
		return citylist;
	}

	@Override
	public int addCity(City city) throws SQLException {
		int status = 0;
		
		Connection connection = ConnectionProvider.getConnection();
		CityDAO cityDAO = new JDBCCityDAO(connection);
		status = cityDAO.save(city);
		
		return status;
	}

	@Override
	public int updatecity(City city) throws SQLException {
		int status = 0;
		
		Connection connection = ConnectionProvider.getConnection();
		CityDAO cityDAO = new JDBCCityDAO(connection);
		status = cityDAO.update(city);
		
		return status;
	}

	@Override
	public City fetchbyId(int id) throws SQLException {
		City city = new City();
		
		Connection connection = ConnectionProvider.getConnection();
		CityDAO cityDAO = new JDBCCityDAO(connection);
		city = cityDAO.findById(id);
		return city;
	}
 
}
