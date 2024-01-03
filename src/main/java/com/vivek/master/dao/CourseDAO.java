package com.vivek.master.dao;

import java.sql.SQLException;
import java.util.List;

import com.vivek.master.model.Course;

public interface CourseDAO {

	int save(Course course) throws SQLException;

	int update(Course course) throws SQLException;

	List<Course> findAll() throws SQLException;

	Course FindById(int id) throws SQLException;

}
