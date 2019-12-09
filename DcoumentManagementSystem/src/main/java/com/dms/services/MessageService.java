package com.dms.services;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dto.MessageDto;
import com.dms.entity.Messages;

@Service
@Transactional
public interface  MessageService {
	
	public void saveMessage(MessageDto message) ;
	public List<Messages> viewAllMessage();
	public Messages searchMessage(Messages message);
	public void deleteMessage(Messages message);
	public List<MessageDto> getSentMessage(long id);
	public List<MessageDto> getReceivedMessage(long id);
	public MessageDto getMessage(long msgId,long userId);
	public void updateReceiveDate(long id,long userId);
	public List<MessageDto> incomeMessage(long userId);
	


}
