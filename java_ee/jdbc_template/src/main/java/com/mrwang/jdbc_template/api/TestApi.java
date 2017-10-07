package com.mrwang.jdbc_template.api;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc_template");
		dataSource.setUsername("root");
		dataSource.setPassword("654123");

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		jdbcTemplate.update(
				"insert into t_user(username,password) values(?,?);", "jimy",
				"999");
	}
}
