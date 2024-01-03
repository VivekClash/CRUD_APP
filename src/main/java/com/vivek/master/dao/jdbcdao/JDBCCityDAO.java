package com.vivek.master.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vivek.dbcon.JDBCbaseDao;
import com.vivek.master.dao.CityDAO;
import com.vivek.master.model.City;
import com.vivek.master.model.State;

public class JDBCCityDAO extends JDBCbaseDao implements CityDAO{
	
	public JDBCCityDAO(Connection connection) {
		this.connection = connection;
		
	}
	
	@Override
	public int save(City city) throws SQLException {
		int status = 0;
		String sqlQuery = "INSERT INTO City(state_id, city_name)VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setLong(1, city.getState().getId());
		ps.setString(2, city.getName());
		System.out.println(ps.toString());
		
		status = ps.executeUpdate();		
		
		return status;
	}
	
	@Override
	public int update(City city) throws SQLException {
		
		int status = 0;
		String sqlQuery = "UPDATE City SET state_id = ?,city_name = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setLong(1, city.getState().getId());
		ps.setString(2, city.getName());
		ps.setLong(3, city.getId());
		System.out.println(ps.toString());
		status = ps.executeUpdate();		
		
		return status;
	}
	
	@Override
	public List<City> findAll() throws SQLException{
		List<City> citylist = new ArrayList<City>();
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT s.id AS stateId,s.state_name AS stateName,c.id AS cityId,c.city_name AS cityName ");
		sqlQuery.append("FROM city c ");
		sqlQuery.append("INNER JOIN state s ON s.id = c.state_id ");
		PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
		ResultSet rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 City city = new City();
			 State state = new State();
			 
			 city.setId(rs.getLong("cityId"));
			 city.setName(rs.getString("cityName")); 
			 
			 city.setState(state);
			 state.setId(rs.getLong("stateId"));
			 state.setName(rs.getString("stateName"));
			 
			 citylist.add(city);
		 }

		return citylist;
	}
	
	@Override
	public City findById(int id) throws SQLException {
		City city = new City();
		State state = new State();
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT s.id AS stateId,c.id AS id,c.city_name AS city_name ");
		sqlQuery.append("FROM city c ");
		sqlQuery.append("INNER JOIN state s ON s.id = c.state_id ");
		sqlQuery.append("WHERE c.id = ? ");
		PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			city.setId(rs.getLong("id"));
			city.setState(state);
			state.setId(rs.getLong("stateId"));
			city.setName(rs.getString("city_name"));
			
			System.out.println(city);
		}
		return city;
	}

}
