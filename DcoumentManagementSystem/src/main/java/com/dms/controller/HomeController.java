package com.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.dao.DepartmentDao;
import com.dms.dao.RoleDao;
import com.dms.dao.User_loginDao;
import com.dms.dto.FileUpload;
import com.dms.entity.User_info;
import com.dms.services.File_detailsService;
import com.dms.services.User_detailsService;
import com.dms.validator.FileUploadValidator;

@Controller
public class HomeController {
	@Autowired 
	private User_detailsService user_detailsDao;
	@Autowired 
	private File_detailsService file_detailsServices;;
	@Autowired 
	private FileUploadValidator fileValidator;
		@RequestMapping(value="/getDepartmentList",produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String getUserRole(@RequestParam(value="user")String user,@RequestParam(value="inputUser")String inputUser){
			System.out.println(user+"from "+inputUser);
			return user+inputUser ;
		}
		@RequestMapping(value="/share_file.htm")
		public String share_File(Model model){
			return "share_file";
		}
}
