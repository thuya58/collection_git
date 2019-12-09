package com.dms.services;

import org.springframework.beans.factory.annotation.Autowired;

public class SecurityUtil {
	@Autowired
	User_detailsService service;
	
	public static String user_Image = "20190720155320th.jpg";
	
public String userImage() {
	return "20190720155320th.jpg";
}
}
