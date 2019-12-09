package com.dms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Share_files implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date send_date;
	@Temporal(TemporalType.DATE)
	private Date receive_date;
	@Temporal(TemporalType.DATE)
	private Date seen_date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date date) {
		this.send_date = date;
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
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "receiver_id")
	private User_info receiver_info = new User_info();

	public User_info getReceiver_info() {
		return receiver_info;
	}

	public void setReceiver_info(User_info receiver_info) {
		this.receiver_info = receiver_info;
	}
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="file_detailId")
	private File_details file_detail=new File_details();

	public File_details getFile_detail() {
		return file_detail;
	}

	public void setFile_detail(File_details file_detail) {
		this.file_detail = file_detail;
	}
	
}
