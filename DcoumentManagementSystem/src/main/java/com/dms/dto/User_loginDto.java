package com.dms.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class User_loginDto implements UserDetails,Serializable{
	 private  User user;

	    public User_loginDto(final User _user) {
	            this.user = _user;
	    }

	    public User_loginDto() {
	    }

	int id;
	String email;
	private String name;
	String password;
	private String photo;
	int role_id;
	private List<GrantedAuthority> authories=new ArrayList<GrantedAuthority>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		 if (this.user == null) {
            return null;
    }
    return this.user.getUsername();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.user.isEnabled();
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.user.isEnabled();
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.user.isEnabled();
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.user.isEnabled();
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<GrantedAuthority> getAuthories() {
		return authories;
	}
	public void setAuthories(List<GrantedAuthority> authories) {
		this.authories = authories;
	}
	public String getName() {
		if (this.user == null) {
            return null;
    }
    return this.user.getName();
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
        return user;
}
}
