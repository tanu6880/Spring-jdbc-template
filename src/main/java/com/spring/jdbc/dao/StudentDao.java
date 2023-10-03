package com.spring.jdbc.dao;

import java.util.List;

import com.springjdbc.entities.Student;

public interface StudentDao {
	
	public int insert(Student student);
	public int update(Student student);
	public int delete(int studentId);
	public Student getstudent(int student);
	public List<Student> Allgetstudent();

}
