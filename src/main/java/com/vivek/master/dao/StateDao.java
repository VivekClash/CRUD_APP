package com.vivek.master.dao;

import java.sql.SQLException;
import java.util.List;

import com.vivek.master.model.State;

public interface StateDao {

	int save(State state) throws SQLException;

	int update(State state) throws SQLException;

	List<State> findAll() throws SQLException;

	State findById(int id) throws SQLException;



}
