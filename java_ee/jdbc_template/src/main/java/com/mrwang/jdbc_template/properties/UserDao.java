package com.mrwang.jdbc_template.properties;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mrwang.jdbc_template.domain.User;

public class UserDao extends JdbcDaoSupport {

	public void update(User user) {
		String sql = "update t_user set username=?,password=? where id =?";
		Object[] args = { user.getUsername(), user.getPassword(), user.getId() };
		getJdbcTemplate().update(sql, args);
	}

	public List<User> findAll() {
		return getJdbcTemplate().query("select * from t_user ",
				ParameterizedBeanPropertyRowMapper.newInstance(User.class));
	}

	public User getById(int id) {
		return getJdbcTemplate().queryForObject(
				"select * from t_user where id=?",
				ParameterizedBeanPropertyRowMapper.newInstance(User.class), id);
	}
}
