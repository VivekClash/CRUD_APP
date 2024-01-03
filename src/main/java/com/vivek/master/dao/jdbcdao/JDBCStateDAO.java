package com.vivek.master.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vivek.dbcon.JDBCbaseDao;
import com.vivek.master.dao.StateDao;
import com.vivek.master.model.State;

public class JDBCStateDAO extends JDBCbaseDao implements StateDao{         //JDBCbasedao is used to provide connection. and stateDao to 
																		   // achieve abstraction
	public JDBCStateDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int save(State state) throws SQLException {
		int status = 0;
		String sqlQuery = "INSERT INTO State(state_name)VALUES (?)";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setString(1, state.getName());
		status = ps.executeUpdate();
		return status;
	}
	
	@Override
	public int update(State state) throws SQLException {
		int status = 0;
		String sqlQuery = "UPDATE State SET state_name = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setString(1, state.getName());
		ps.setLong(2, state.getId());
		System.out.println(ps.toString());
		status = ps.executeUpdate();
		return status;
		
	}
	
	@Override
	public List<State> findAll() throws SQLException{
		List<State> statelist =  new ArrayList<State>();
		String sqlQuery ="SELECT id,state_name FROM State";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			State state = new State();
			state.setId(rs.getLong("id"));
			state.setName(rs.getString("state_name"));
			
			statelist.add(state);
			
		}
		return statelist;
	}
	
	@Override
	public State findById(int id) throws SQLException {
		State state = new State();
		String sqlQuery ="SELECT id,state_name FROM State WHERE id=?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			state.setId(rs.getLong("id"));
			state.setName(rs.getString("state_name"));
//			System.out.println(state);
		}
		
		return state;
	}
}
