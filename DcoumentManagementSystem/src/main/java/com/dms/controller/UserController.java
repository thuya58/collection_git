package com.dms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dms.dao.DepartmentDao;
import com.dms.dao.RoleDao;
import com.dms.dao.User_loginDao;
import com.dms.dto.Change_passwordDto;
import com.dms.dto.User_profile;
import com.dms.dto.User_registerDto;
import com.dms.services.FileTypeServices;
import com.dms.services.File_detailsService;
import com.dms.services.User_detailsService;

@Controller
public class UserController {
	@Autowired 
	private RoleDao roleDao;
	@Autowired 
	private DepartmentDao departmentDao;
	@Autowired 
	private User_detailsService user_detailsService;
	@Autowired
	private User_loginDao user_loginDao;
	@Autowired
	private File_detailsService fileService;
	@Autowired
	private FileTypeServices fileType;
	@RequestMapping(value="/index.htm")
	public String LoginSuccess(Model model){
		User_profile user=user_detailsService.user_profile();
		model.addAttribute("imageList",fileService.searchByType(user.getId(), "jpg"));
		model.addAttribute("audioList",fileService.searchByType(user.getId(), "mp3"));
		model.addAttribute("videoList",fileService.searchByType(user.getId(), "mp4"));
		model.addAttribute("pdfList",fileService.searchByType(user.getId(), "pdf"));
		model.addAttribute("wordList",fileService.searchByType(user.getId(), "docx"));
		model.addAttribute("execlList",fileService.searchByType(user.getId(), "xlsx"));
		return "welcome";	
	}
	@RequestMapping(value="/login.htm")
	public String welcome(){
		return "login";
	}
	
	@RequestMapping(value="/user_register.htm")
	public String home(Model model) {
		model.addAttribute("user_registerDTO",new User_registerDto());
		model.addAttribute("role_list",roleDao.viewAllRole());
		model.addAttribute("department_list",departmentDao.viewAllDepartment());
		return "user_register";
	}
	
	@RequestMapping(value="/user_register.htm",method=RequestMethod.POST)
	public String successRgister(Model model,@Validated @ModelAttribute("user_registerDTO")User_registerDto user_registerDTO,BindingResult result){
		boolean error=user_loginDao.checkEmail(user_registerDTO.getEmail());
		System.out.println(error+"error");
		if(!result.hasErrors()&&error==true) {
		user_detailsService.saveUser(user_registerDTO);
		}
		else { model.addAttribute("errorMsg", "Email is Already Exist");
			model.addAttribute("user_registerDTO",new User_registerDto());
			model.addAttribute("role_list",roleDao.viewAllRole());
			model.addAttribute("department_list",departmentDao.viewAllDepartment());
 			return "user_register";
		}
		return "welcome";
	}
	
	@RequestMapping(value="/logout.htm", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/login.htm";  
     } 
	
	@RequestMapping(value="/profile.htm")
	public String profile(Model model){
		model.addAttribute("profile",user_detailsService.user_profile());
		return "profile";
	}
	
	@RequestMapping(value="/view_types.htm/{type}")
	public String viewType(Model model, @PathVariable(value = "type") String type){
		System.out.println(type);
		User_profile user=user_detailsService.user_profile();
		model.addAttribute("ownFile",fileService.searchByType(user.getId(), type));
		return "myfile";
	}
}
