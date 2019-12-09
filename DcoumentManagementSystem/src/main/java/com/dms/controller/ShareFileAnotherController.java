package com.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dms.dto.User_profile;
import com.dms.services.ShareFileAnotherService;
import com.dms.services.User_detailsService;

@Controller
public class ShareFileAnotherController {
	@Autowired
	private ShareFileAnotherService sharefile;
	@Autowired 
	private User_detailsService user_detailsService;
	
	@RequestMapping(value="/sharefile_another.htm")
	public String home(Model model) {
		User_profile user=user_detailsService.user_profile();
		model.addAttribute("sharefile_list",sharefile.shareFile(user.getId()));
		return "share_file_another";
	}
	@RequestMapping(value="/sharefile_to_another.htm")
	public String sharefiletoanother(Model model) {
		User_profile user=user_detailsService.user_profile();
		model.addAttribute("sharefile_to_another_list",sharefile.shareFileAnother(user.getId()));
		return "share_file_to_another";
	}
}