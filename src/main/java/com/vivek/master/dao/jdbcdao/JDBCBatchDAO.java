package com.vivek.master.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vivek.dbcon.JDBCbaseDao;
import com.vivek.master.dao.BatchDAO;
import com.vivek.master.model.Batch;

public class JDBCBatchDAO extends JDBCbaseDao implements BatchDAO{
	
	public JDBCBatchDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public int save (Batch batch) throws SQLException {
		int status = 0;
		String sqlQuery = "INSERT INTO Batch(batch_name) VALUES (?)";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setString(1, batch.getName());
		status = ps.executeUpdate();		
		return status;
	}
	
	@Override
	public int update (Batch batch) throws SQLException {
		int status = 0;
		String sqlQuery = "UPDATE Batch SET batch_name = ? WHERE id =?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setString(1, batch.getName());
		ps.setLong(2, batch.getId());
		status = ps.executeUpdate();		
		return status;
	}
	
	@Override
	public List<Batch> findAll() throws SQLException{
		List<Batch> batchlist = new ArrayList<Batch>();
		String sqlQuery = "SELECT id,batch_name FROM Batch";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Batch batch = new Batch();
			batch.setId(rs.getLong("id"));
			batch.setName(rs.getString("batch_name"));
			
			batchlist.add(batch);
		}
		
		return batchlist;
	}
	
	@Override
	public Batch FindById(int id) throws SQLException {
		Batch batch = new Batch();
		String sqlQuery = "SELECT id,batch_name FROM Batch WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			batch.setId(rs.getLong("id"));
			batch.setName(rs.getString("batch_name"));
			System.out.println(batch);
		}
		return batch;
	}
	
	

}
