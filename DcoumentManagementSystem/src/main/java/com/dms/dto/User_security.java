package com.dms.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class User_security extends User {

	public User_security(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	private long id;
	private String photo;
	private String name;
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User_security(String username, String password,String name,String photo,long id,
			Collection<? extends GrantedAuthority> authorities) {
			super(username, password, authorities);
			this.photo=photo;
			this.name=name;
			this.id=id;
			// TODO Auto-generated constructor stub
			}
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return super.getAuthorities();
	}

}
