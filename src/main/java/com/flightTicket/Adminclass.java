package com.flightTicket;

public class Adminclass {
	private String name;
	private String password;
	public Adminclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Adminclass(String name,String password) {
		super();
		this.name=name;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		

}
