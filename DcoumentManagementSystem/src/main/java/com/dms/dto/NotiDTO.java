package com.dms.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NotiDTO {

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
	public String getNotitype() {
		return notitype;
	}
	public void setNotitype(String notitype) {
		this.notitype = notitype;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	private long id;
	private String title;
	private String notitype;
	 @Temporal(TemporalType.TIMESTAMP)
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date send_date;
	private String sendDateString;
	private String senderName;
	public String getSendDateString() {
		return sendDateString;
	}
	public void setSendDateString(String sendDateString) {
		this.sendDateString = sendDateString;
	}
	
}
