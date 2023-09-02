package com.flightTicket;

public class PersonalDetails {
	private int persionId;
	private String personName;
	private int age;
	private String gender;
	private int fId;

	public PersonalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalDetails(int persionId,String personName,int age,String gender,int fId) {
		super();
		this.persionId=persionId;
		this.personName=personName;
		this.age=age;
		this.gender=gender;
		this.fId=fId;
	
	}
	public int getPersionId() {
		return persionId;
	}
	public void setPersionId(int persionId) {
		this.persionId = persionId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
}
