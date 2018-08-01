package com.mrwang.mybaits.po;

import java.util.List;

public class OrdersExt extends Orders {
	private String username;
	private String sex;

	private User user;
	private List<Orderdetail> detailList;

	public List<Orderdetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<Orderdetail> detailList) {
		this.detailList = detailList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
