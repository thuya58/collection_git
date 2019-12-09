package com.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dms.dao.DepartmentDao;
import com.dms.dao.User_infoDao;

@Controller
public class DepartmentController {
	@Autowired 
	private DepartmentDao departmentDao;
	@Autowired
	private User_infoDao user_infoDao;
	@RequestMapping(value = "/departmentList.htm")
	public String deoartnmentList(Model model) {
		model.addAttribute("department",departmentDao.viewAllDepartment());
		return "departmentList";
	}
	@RequestMapping(value = "/viewByDepartment.htm/{id}")
	public String viewByDepartment(Model model, @PathVariable(value = "id") Long id) {
		model.addAttribute("User_info",user_infoDao.searchWithDepartment(id));
		return "userlist";
	}
}
