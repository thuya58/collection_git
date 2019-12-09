package com.dms.dto;

import java.sql.Date;
import java.util.List;

public class Share_fileDto {
	private long id;
	private List<Long> receiver;
	private Date send_date;
	private Date receive_date;
	private Date seen_date;
	private long sender_id;
	private long file_id;
	private String senderName;
	private String receiverName;
	private String fileName;
	private String location;
	private List<Long> fileList;
	private List<Long> departmentList;
	public List<Long> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Long> departmentList) {
		this.departmentList = departmentList;
	}
	public List<Long> getFileList() {
		return fileList;
	}
	public void setFileList(List<Long> fileList) {
		this.fileList = fileList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<Long> getReceiver() {
		return receiver;
	}
	public void setReceiver(List<Long> receiver) {
		this.receiver = receiver;
	}
	public long getFile_id() {
		return file_id;
	}
	public void setFile_id(long file_id) {
		this.file_id = file_id;
	}
	
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public Date getReceive_date() {
		return receive_date;
	}
	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}
	public Date getSeen_date() {
		return seen_date;
	}
	public void setSeen_date(Date seen_date) {
		this.seen_date = seen_date;
	}
	public long getSender_id() {
		return sender_id;
	}
	public void setSender_id(long sender_id) {
		this.sender_id = sender_id;
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
	
}
