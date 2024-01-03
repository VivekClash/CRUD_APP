package com.vivek.master.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vivek.dbcon.JDBCbaseDao;
import com.vivek.master.dao.BranchDAO;

import com.vivek.master.model.Branch;


public class JDBCBranchDAO extends JDBCbaseDao implements BranchDAO{
	
	public JDBCBranchDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int save (Branch branch) throws SQLException {
		int status = 0;
		String sqlQuery = "INSERT INTO Branch(branch_name) VALUES (?)";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setString(1, branch.getName());
		status = ps.executeUpdate();		
		return status;
	}
	
	@Override
	public int update (Branch branch) throws SQLException {
		int status = 0;
		String sqlQuery = "UPDATE Branch SET branch_name = ? WHERE id =?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setString(1, branch.getName());
		ps.setLong(2, branch.getId());
		status = ps.executeUpdate();		
		return status;
	}
	
	@Override
	public List<Branch> findAll() throws SQLException{
		List<Branch> branchlist = new ArrayList<Branch>();
		String sqlQuery = "SELECT id,branch_name FROM Branch";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Branch branch = new Branch();
			branch.setId(rs.getLong("id"));
			branch.setName(rs.getString("batch_name"));
			
			branchlist.add(branch);
		}
		return branchlist;
	}
	
	@Override
	public Branch FindById (int id) throws SQLException {
		
		Branch branch = new Branch();
		String sqlQuery = "SELECT id,branch_name FROM Branch WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			branch.setId(rs.getLong("id"));
			branch.setName(rs.getString("batch_name"));
			System.out.println(branch);
		}
		return branch;
	}
	
}
