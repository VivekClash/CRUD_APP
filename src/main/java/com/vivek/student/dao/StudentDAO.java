package com.vivek.student.dao;

import java.sql.SQLException;
import java.util.List;

import com.vivek.student.model.Student;

public interface StudentDAO {
	
	public int save(Student student) throws SQLException;
	
	public int update(Student student);
	
	public List<Student> findAll();
	
	public Student findById();

}
