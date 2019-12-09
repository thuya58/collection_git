package com.dms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dms.dao.RoleDao;
import com.dms.entity.User_role;
@Controller
public class RoleController {
	@Autowired RoleDao roledao;
	
	@RequestMapping(value="/rolea.htm")
	public String Role(Model model) {
		 model.addAttribute("role",new User_role());   
		return "role1";
	}
	@RequestMapping(value="/role.htm",method=RequestMethod.POST,params = { "save" })
	public String saveRole(Model model,@ModelAttribute("role")User_role role) {
		roledao.saveOrUpdateRole(role);
		return "role1";
	}
}
