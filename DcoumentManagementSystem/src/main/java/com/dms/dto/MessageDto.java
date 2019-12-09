package com.dms.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MessageDto {
	
	long id;
	String title;
	String description;
	String sender;
	private long senderId;
	
	private String senderName;
	private String receiverName;
	private Date sendDate;
	private Date receivedDate;

List<Long> receiver_list=new ArrayList<Long>();

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public List<Long> getReceiver_list() {
	return receiver_list;
}
public void setReceiver_list(List<Long> receiver_list) {
	this.receiver_list = receiver_list;
}
public long getSenderId() {
	return senderId;
}
public void setSenderId(long senderId) {
	this.senderId = senderId;
}
public String getSenderName() {
	return senderName;
}
public void setSenderName(String senderName) {
	this.senderName = senderName;
}
public String getReceiverName() {
	return receiverName;
}
public void setReceiverName(String receiverName) {
	this.receiverName = receiverName;
}
public Date getSendDate() {
	return sendDate;
}
public void setSendDate(Date sendDate) {
	this.sendDate = sendDate;
}
public Date getReceivedDate() {
	return receivedDate;
}
public void setReceivedDate(Date receivedDate) {
	this.receivedDate = receivedDate;
}



}
