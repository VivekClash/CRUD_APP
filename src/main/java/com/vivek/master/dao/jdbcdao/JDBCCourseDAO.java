package com.vivek.master.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vivek.dbcon.JDBCbaseDao;
import com.vivek.master.dao.CourseDAO;
import com.vivek.master.model.Course;

public class JDBCCourseDAO extends JDBCbaseDao implements CourseDAO {
	
	public JDBCCourseDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public int save (Course course) throws SQLException {
		int status = 0;
		String sqlQuery = "INSERT INTO Course(branch_id,course_name) VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setInt(1, course.getBranch_id());
		ps.setString(2, course.getName());
		status = ps.executeUpdate();		
		return status;
	}
	
	@Override
	public int update (Course course) throws SQLException {
		int status = 0;
		String sqlQuery = "UPDATE Course SET branch_id = ?,course_name = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setInt(1, course.getBranch_id());
		ps.setString(2, course.getName());
		ps.setLong(3, course.getId());
		status = ps.executeUpdate();		
		return status;
	}
	
	@Override
	public List<Course> findAll() throws SQLException{
		List<Course> courselist = new ArrayList<Course>();
		String sqlQuery = "SELECT id,branch_id,course_name FROM Course";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Course course = new Course();
			course.setId(rs.getLong("id"));
			course.setBranch_id(rs.getInt("branch_id"));
			course.setName(rs.getString("course_name"));
			
			courselist.add(course);
			
		}
		return courselist;
	}
	
	@Override
	public Course FindById(int id) throws SQLException {
		Course course = new Course();
		String sqlQuery = "SELECT id,branch_id,course_name FROM course WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sqlQuery);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			course.setId(rs.getLong("id"));
			course.setBranch_id(rs.getInt("branch_id"));
			course.setName(rs.getString("course_name"));
			
			System.out.println(course);
		}
		
		return course;
	}

}
