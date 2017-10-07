package com.mrwang.jdbc_template.dpcp;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

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

	public List<User> findAll() {
		return jdbcTemplate.query("select * from t_user ",
				ParameterizedBeanPropertyRowMapper.newInstance(User.class));
	}
}
