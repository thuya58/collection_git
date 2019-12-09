package com.dms.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dms.dao.User_infoDao;
import com.dms.dto.MessageDto;
import com.dms.entity.User_info;
import com.dms.services.MessageService;
import com.dms.services.User_detailsService;
import com.dms.services.User_loginService;

@Controller
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private User_infoDao userInfoDao;
	@Autowired 
	private User_detailsService user_detailsDao;
	@InitBinder
	protected void intiBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		
	}
	@RequestMapping(value="/messagesend.htm")
	public String messagesend(Model model) {
		model.addAttribute("message",new MessageDto());
		model.addAttribute("userList",userInfoDao.viewAllUser_info());
		return "messagesend";
	}
	
	@RequestMapping(value="/message_send.htm",method=RequestMethod.POST)
	public String saveMessage(Model model,@ModelAttribute("message")MessageDto message) {

		 try { 
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = ((UserDetails)principal).getUsername();
			User_info user=user_detailsDao.search_User_info(username);
			message.setSenderId(user.getId());
			int result=message.getReceiver_list().size();
			System.out.println(result+message.getDescription()+message.getTitle()+"message send controller ");
			messageService.saveMessage(message);
			return "redirect:/view_message.htm";
		} catch (Exception ex) {
			model.addAttribute("message", message);
			model.addAttribute("toUser", userInfoDao.viewAllUser_info());
			model.addAttribute("error", ex.getMessage());
			return "messagesend";
		}
		
	
	}
	
	@RequestMapping(value="/view_message.htm",method=RequestMethod.GET)
	public String viewMessage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User_info user=user_detailsDao.search_User_info(username);
		model.addAttribute("messageList", messageService.getSentMessage(user.getId()));
		return "viewMessage";
	}
	
	@RequestMapping(value="/view_receivedMessage.htm",method=RequestMethod.GET)
	public String viewSendMessage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User_info user=user_detailsDao.search_User_info(username);
		model.addAttribute("messageList", messageService.getReceivedMessage(user.getId()));
		return "receivedMessage";
	}
	

	@RequestMapping(value="/message_detail.htm/{id}")
	public String viewMessageDetail(Model model,@PathVariable(value="id")long id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User_info user=user_detailsDao.search_User_info(username);
		MessageDto msg=messageService.getMessage(id, user.getId());
		if(msg.getReceivedDate()==null)
		 messageService.updateReceiveDate(id,user.getId());
		 model.addAttribute("message",msg);
		
		return "message_detail";
	}
}
