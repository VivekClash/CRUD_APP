package com.vivek.student.dao.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vivek.dbcon.JDBCbaseDao;
import com.vivek.student.dao.StudentDAO;
import com.vivek.student.model.Student;


public class JDBCstudentDAO extends JDBCbaseDao implements StudentDAO{
	
	public JDBCstudentDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int save(Student student) throws SQLException {
		int status=0;
		String sqlQuery = "INSERT INTO student_table "
				+ "(First_name,Last_name,Contact_no,Email,Gender,Address,state_id,city_id,date_of_birth) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps= connection.prepareStatement(sqlQuery);
		ps.setString(1, student.getFirst_name());
		ps.setString(2, student.getLast_name());
		ps.setString(3, student.getContact_no());
		ps.setString(4, student.getEmail());
		ps.setString(5, student.getGender());
		ps.setString(6, student.getAddress());
		ps.setLong(7, student.getState().getId());
		ps.setLong(8, student.getCity().getId());
		ps.setInt(9, student.getDate_of_birth());
		
		status=ps.executeUpdate();
		return status;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findAll() {
		List<Student> studentlist = new ArrayList<Student>();
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("");
		return studentlist;
	}

	@Override
	public Student findById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
