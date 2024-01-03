package com.vivek.master.dao;

import java.sql.SQLException;
import java.util.List;

import com.vivek.master.model.Branch;

public interface BranchDAO {

	int save(Branch branch) throws SQLException;

	int update(Branch branch) throws SQLException;

	List<Branch> findAll() throws SQLException;

	Branch FindById(int id) throws SQLException;

}
