package com.mrwang.f_xml.c_p;

public class Person {
	private String pname;
	private Integer age;

	private Address homeAddr;
	private Address comAddr;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(Address homeAddr) {
		this.homeAddr = homeAddr;
	}

	public Address getComAddr() {
		return comAddr;
	}

	public void setComAddr(Address comAddr) {
		this.comAddr = comAddr;
	}

	@Override
	public String toString() {
		return "Person [pname=" + pname + ", age=" + age + ", homeAddr="
				+ homeAddr + ", comAddr=" + comAddr + "]";
	}

}
