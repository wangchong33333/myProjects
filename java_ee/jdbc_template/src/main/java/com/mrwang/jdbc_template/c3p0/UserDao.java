package com.mrwang.jdbc_template.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mrwang.jdbc_template.domain.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void update(User user) {
		String sql = "update t_user set username=?,password=? where id =?";
		Object[] args = { user.getUsername(), user.getPassword(), user.getId() };
		jdbcTemplate.update(sql, args);
	}
}
