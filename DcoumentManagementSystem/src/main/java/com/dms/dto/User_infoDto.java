package com.dms.dto;

public class User_infoDto {
	int id;
	String name;
	String address;
	String phno;
	String nrc;
	String photo;
	int department_id;
	int own_location_id;
	int user_login_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getOwn_location_id() {
		return own_location_id;
	}
	public void setOwn_location_id(int own_location_id) {
		this.own_location_id = own_location_id;
	}
	public int getUser_login_id() {
		return user_login_id;
	}
	public void setUser_login_id(int user_login_id) {
		this.user_login_id = user_login_id;
	}
	
}
