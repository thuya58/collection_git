package com.dms.dao;

import java.util.List;

import com.dms.dto.MessageDto;
import com.dms.entity.Messages;
import com.dms.entity.Message_Send;

public interface MessageDao {
	public List<Messages> viewAllMessage();
	public Messages searchMessage(Messages message);
	public void deleteMessage(Messages message);
	public long saveMessage(Messages message);
	public void sendMessage(Message_Send msgSend);
	public List<MessageDto> getSentMessage(long id);
	public List<MessageDto> getReceivedMessage(long id);
	public MessageDto getMessage(long msgId,long userId); 
	public void updateReceiveDate(long id,long userId);
	public Messages getMessage(long msgId);
	public List<MessageDto> incomeMessage(long userId);
}
