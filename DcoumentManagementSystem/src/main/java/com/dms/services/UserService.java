package com.dms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.User_loginDao;
import com.dms.dto.User_security;
import com.dms.entity.User_info;
import com.dms.entity.User_login;
@Service
@Transactional
public class UserService implements UserDetailsService {
	@Autowired 
	User_loginDao user_loginDao;
	@Autowired
	private User_detailsService user_detailsServices;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

    User_login user=user_loginDao.findUserByEmail(username);
	User_info user_info=user_detailsServices.search_profile(username);	
		List<GrantedAuthority> authories=new ArrayList<GrantedAuthority>();
				
			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRole_level());
			authories.add(authority);
			
			UserDetails userDetails = (UserDetails)new User_security(user.getEmail(), user.getPassword(), user_info.getName(), user_info.getPhoto(),user_info.getId(), authories);
			
			
		return userDetails;
	}

}
