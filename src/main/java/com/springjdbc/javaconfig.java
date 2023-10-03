package com.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoimpl;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.dao")
public class javaconfig {

	@Bean("ds")
	public DataSource AddDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/test/test");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate temp = new JdbcTemplate();
		temp.setDataSource(AddDataSource());
		return temp;
	}
	
	@Bean(name={"studentDao"})
	public StudentDao getDao()
	{
		StudentDaoimpl sd = new StudentDaoimpl();
		sd.setJdbcTemplate(getJdbcTemplate());
		return sd;
	}
}
