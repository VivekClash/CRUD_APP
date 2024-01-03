package com.vivek.master.dao;

import java.sql.SQLException;
import java.util.List;

import com.vivek.master.model.Batch;

public interface BatchDAO {

	int save(Batch batch) throws SQLException;

	int update(Batch batch) throws SQLException;

	List<Batch> findAll() throws SQLException;

	Batch FindById(int id) throws SQLException;

}
