package com.dms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dms.dao.DepartmentDao;
import com.dms.dao.RoleDao;
import com.dms.dao.User_infoDao;
import com.dms.dao.User_loginDao;
import com.dms.dto.Change_passwordDto;
import com.dms.dto.FileUpload;
import com.dms.dto.User_profile;
import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;
import com.dms.entity.User_login;
import com.dms.entity.User_role;
@Service
@Transactional
public class User_detailsServiceImp implements User_detailsService{
	@Autowired 
	private User_loginDao user_loginDao;
	@Autowired 
	private User_infoDao user_infoDao;
	@Autowired 
	private File_detailsService file_detailsDao;
	@Autowired 
	private BCryptPasswordEncoder bcryptEncoder;
	@Autowired 
	private User_detailsService user_detailsDao;
	@Autowired 
	private DepartmentDao departmentDao;
	@Autowired
	private RoleDao user_roleDao;
	
	public void saveUser(User_registerDto user_registerDto) {
		// TODO Auto-generated method stub
		User_login userLogin = new User_login();
		String password=user_registerDto.getPassword();
		userLogin.setEmail(user_registerDto.getEmail());
		userLogin.setPassword(bcryptEncoder.encode(password));
		userLogin.getRole().setId(user_registerDto.getRole_id());
		System.out.println(password+userLogin.getEmail()+userLogin.getRole().getId()+"before save");
		user_loginDao.saveOrUpdateUser_login(userLogin);
		
		User_info user_info = new User_info();
		user_info.setName(user_registerDto.getName());
		user_info.setAddress(user_registerDto.getAddress());
		user_info.setPhno(user_registerDto.getPhno());
		user_info.setNrc(user_registerDto.getNrc());
		FileUpload uploaded_file=new FileUpload();
		uploaded_file.setFile(user_registerDto.getPhoto());
		user_info.setPhoto(file_detailsDao.upload_File(uploaded_file,user_info.getName()));
		user_info.getDepartment().setId(user_registerDto.getDepartment_id());
		
		long id=user_loginDao.findUserByEmail(userLogin.getEmail()).getId();
		user_info.getUser_login().setId(id);
		user_infoDao.saveOrUpdateUser_info(user_info);
		
	}
	
	public boolean checkPassword(User_login user_login) {
		// TODO Auto-generated method stub
		User_login search_user=user_loginDao.searchUser_login(user_login);
		if(search_user==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public User_info search_User_info(String email) {
		// TODO Auto-generated method stub
				System.out.println(user_loginDao.searchId(email));
				return user_infoDao.search_User(user_loginDao.findUserByEmail(email).getId());
	}

	public User_info search_profile(String email) {
		// TODO Auto-generated method stub
		
		User_info user=user_detailsDao.search_User_info(email);
		return user;
	}

	@Override
	public boolean change_password(Change_passwordDto cp) {
		// TODO Auto-generated method stub
		String email=cp.getEmail();
		User_login user=user_loginDao.searchId(email);
		String password=cp.getCurrent_password();
		if(bcryptEncoder.matches(password, user.getPassword())&&(cp.getNew_password().equals(cp.getConfirm_password()))) {
			user.setPassword(bcryptEncoder.encode(cp.getConfirm_password()));
			user_loginDao.saveOrUpdateUser_login(user);
			System.out.println("changed password");
			return true;
		}else {
			System.out.println("wrong password");
			return false;
			
		}
	}
	
	public User_profile user_profile() {
		// TODO Auto-generated method stub
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User_info user=user_detailsDao.search_User_info(username);
		String department=departmentDao.searchDepartment(user.getDepartment().getId()).getDepartment();
		User_login user_login=user_loginDao.searchId(username);
		User_role user_role=user_roleDao.searchRole(user_login.getRole().getId());
		User_profile user_profile=new User_profile();
		user_profile.setId(user.getId());
		user_profile.setName(user.getName());
		user_profile.setAddress(user.getAddress());
		user_profile.setEmail(username);
		user_profile.setPhno(user.getPhno());
		user_profile.setRole(user_role.getRole_level());
		user_profile.setDepartment(department);
		user_profile.setPhoto(user.getPhoto());
		user_profile.setNrc(user.getNrc());
		return user_profile;
	}
}
