package com.vivek.master.dao;

import java.sql.SQLException;
import java.util.List;

import com.vivek.master.model.City;

public interface CityDAO {

	int save(City city) throws SQLException;

	int update(City city) throws SQLException;

	List<City> findAll() throws SQLException;

	City findById(int id) throws SQLException;

}
