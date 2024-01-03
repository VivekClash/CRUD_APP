package com.vivek.master.service;

import java.sql.SQLException;
import java.util.List;

import com.vivek.master.model.State;

public interface StateService {
	
	
	public List<State> searchAll() throws SQLException;

	int create(State state) throws SQLException;

	int modify(State state) throws SQLException;

	State fetchState(int id) throws SQLException;

}
