package com.dms.dto;

public class File_detailsDto {
	private long id;
	private String name;
	private long user_id;
	private long file_location_id;
	private String path;
	private String owner;
	private String type;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getFile_location_id() {
		return file_location_id;
	}
	public void setFile_location_id(long file_location_id) {
		this.file_location_id = file_location_id;
	}
	
}
