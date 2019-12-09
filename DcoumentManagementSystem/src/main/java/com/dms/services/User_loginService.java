package com.dms.services;

import java.util.List;

import com.dms.dto.AccountDto;
import com.dms.entity.User_login;

public interface User_loginService {
	public List<AccountDto> viewAllUser_login();
	public User_login searchId(String email);
	public boolean checkEmail(String email);
	public String getNewPassword(String email);
}
