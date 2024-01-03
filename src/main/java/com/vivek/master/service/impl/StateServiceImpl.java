package com.vivek.master.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vivek.dbcon.ConnectionProvider;
import com.vivek.master.dao.StateDao;
import com.vivek.master.dao.jdbcdao.JDBCStateDAO;
import com.vivek.master.model.State;
import com.vivek.master.service.StateService;

public class StateServiceImpl implements StateService {

	@Override
	public List<State> searchAll() throws SQLException {
		List<State> statelist = new ArrayList<State>();
		
		Connection connection = ConnectionProvider.getConnection();
		StateDao stateDao = new JDBCStateDAO(connection);
		statelist = stateDao.findAll();
		return statelist;
	}
	
	@Override
	public int create(State state) throws SQLException {
		int status = 0;
		
		//validations to check if obj is null? not written..
		
		Connection connection = ConnectionProvider.getConnection();
		StateDao stateDao = new JDBCStateDAO(connection);
		status = stateDao.save(state);
		
		return status;
	}
	
	@Override
	public int modify(State state) throws SQLException {
		int status = 0;
		
		Connection connection = ConnectionProvider.getConnection();
		StateDao stateDao = new JDBCStateDAO(connection);
		status = stateDao.update(state);
		return status;
	}
	
	@Override
	public State fetchState(int id) throws SQLException {
		State state = new State();
		
		Connection connection = ConnectionProvider.getConnection();
		StateDao stateDao = new JDBCStateDAO(connection);
		state = stateDao.findById(id);
		return state;
	}
	

}
