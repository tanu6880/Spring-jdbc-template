package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;

@Component("studentDao")
public class StudentDaoimpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		
		String query = "insert into class(id, name, city) values (?, ?, ?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}

	@Override
	public int update(Student student) {
		
		String query = "update class set name=? , city=? where id = ?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}

	@Override
	public int delete(int studentId) {
		String query = "delete from class where id = ?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
		
	}

	@Override
	public Student getstudent(int studentId) {
		String query =  " Select * from student where id = ?";
		RowMapper<Student> rowMapper = new rowMapperimpl();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}

	@Override
	public List<Student> Allgetstudent() {
		
		String query =  " Select * from student";
		RowMapper<Student> rowMapper = new rowMapperimpl();
		List<Student> list = this.jdbcTemplate.query(query,rowMapper);
		return list;
	}


}
