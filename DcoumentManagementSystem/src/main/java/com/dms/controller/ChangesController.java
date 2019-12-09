package com.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dms.dao.DepartmentDao;
import com.dms.dao.RoleDao;
import com.dms.dto.Change_passwordDto;
import com.dms.dto.User_loginDto;
import com.dms.dto.User_registerDto;
import com.dms.services.ApplicationMailer;
import com.dms.services.User_detailsService;
import com.dms.services.User_loginService;
import com.sun.tools.sjavac.server.SysInfo;

@Controller
public class ChangesController {
	
	@Autowired
	ApplicationMailer appMailer;
	@Autowired
	User_detailsService user_detailsService;
	@Autowired
	RoleDao roleDao;
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	com.dms.services.User_infoService User_infoService;
	@Autowired
	User_loginService user_loginService;

	@RequestMapping(value = "/change_password.htm")
	public String change_password(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		model.addAttribute("email", username);
		model.addAttribute("change_password", new Change_passwordDto());
		return "change_password";
	}

	@RequestMapping(value = "/change.htm")
	public String change(Model model, @ModelAttribute("change_password") Change_passwordDto change_password) {
		boolean result = user_detailsService.change_password(change_password);
		if (result) {
			return "change_password";
		} else {
			return "welcome";
		}
	}

	@RequestMapping(value = "/userlist.htm")
	public String viewUserList(Model model) {

		model.addAttribute("User_info", User_infoService.viewAllUser_info());
		model.addAttribute("role_list", roleDao.viewAllRole());
		model.addAttribute("department_list", departmentDao.viewAllDepartment());
		return "userlist";

	}

	@RequestMapping(value = "/changedepartment.htm/{id}")
	public String DeleteMessage(Model model, @PathVariable(value = "id") long id) {
		System.out.println(id+"id Strign");
		model.addAttribute("user_registerDTO",new User_registerDto());
		model.addAttribute("user", User_infoService.searchUser_info(id));
		model.addAttribute("role_list", roleDao.viewAllRole());
		model.addAttribute("department_list", departmentDao.viewAllDepartment());
		return "change_department";

	}
	
 
	@RequestMapping(value = "/mychange.htm", method= RequestMethod.POST)
	public String addCountry(Model model,@ModelAttribute("user_registerDTO") User_registerDto user) {	
		if(user.getId() == 0)
		{
			user_detailsService.saveUser(user);
		}
		else
		{	
			User_infoService.updateUser(user);
		}
 
		return "redirect:/userlist.htm";
	}
	@RequestMapping(value ="/forgot_password.htm")
	public String forgotpassword(Model model) {
		model.addAttribute("User_registerDto", new User_registerDto());
		return "forgot_password";
	}
	
	@RequestMapping(value = "/add_password.htm")
	public String addpassword(Model model,@ModelAttribute(value = "User_registerDto") User_registerDto User_registerDto) {
		model.addAttribute("User_registerDto", new User_registerDto());
		String mymail=User_registerDto.getEmail();
		boolean result=user_loginService.checkEmail(mymail);
		String newpass=user_loginService.getNewPassword(mymail);
		System.out.println(result);
		if(result) {
			return "forgot_password";
		}
		else {
			appMailer.sendMail(mymail, "e-Office", "New password of your e-Office account is "+ newpass+".For Your security,don't share your password with anyone else.");
			return "redirect:/login.htm";
		}

	}	
	
}
