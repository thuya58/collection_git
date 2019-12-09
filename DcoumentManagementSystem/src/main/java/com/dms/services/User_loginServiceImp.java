package com.dms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.User_loginDao;
import com.dms.dto.AccountDto;
import com.dms.entity.User_login;

@Service
@Transactional
public class User_loginServiceImp implements User_loginService {
	@Autowired
	private User_loginDao user_loginDao;

	@Override
	public List<AccountDto> viewAllUser_login() {
// TODO Auto-generated method stub
		List<User_login> user = new ArrayList<User_login>();
		List<AccountDto> result = new ArrayList<AccountDto>();
		user = user_loginDao.viewAllUser_login();
		for (User_login u : user) {
			AccountDto account = new AccountDto();
			account = convertBeanAccountDto(u);
			result.add(account);
		}
		return result;
	}

	public AccountDto convertBeanAccountDto(User_login userLogin) {
		AccountDto acc = new AccountDto();
		acc.setId(userLogin.getId());
		acc.setEmail(userLogin.getEmail());
		acc.setPassword(userLogin.getPassword());
		acc.setRole_id(userLogin.getRole().getId());
		return acc;

	}

	public User_login convertUserLogin(AccountDto accountDto) {
		User_login userLogin = new User_login();
		if (accountDto.getId() != 0) {
			userLogin.setId(accountDto.getId());

		}
		userLogin.getRole().setId(accountDto.getId());
		userLogin.setEmail(accountDto.getEmail());
		userLogin.setPassword(accountDto.getPassword());
		return userLogin;

	}

	@Override
	public User_login searchId(String email) {
// TODO Auto-generated method stub
		return user_loginDao.searchId(email);
	}

	@Override
	public boolean checkEmail(String email) {
// TODO Auto-generated method stub
		return user_loginDao.checkEmail(email);
	}

	@Override
	public String getNewPassword(String mail) {
// TODO Auto-generated method stub

		return user_loginDao.getNewPassword(mail);
	}
}