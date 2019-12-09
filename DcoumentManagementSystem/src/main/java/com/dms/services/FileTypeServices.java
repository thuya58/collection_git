package com.dms.services;

import java.util.List;

import com.dms.dto.FileTypeDto;

public interface FileTypeServices {
	public boolean createFile(String name);
	public boolean renameFile(String newName,String oldName);
	public boolean deleteFile(String name);
	public void saveFile_location(FileTypeDto name);
	public void updateFile_location(FileTypeDto name);
	public void deleteFile_location(FileTypeDto name);
	public List<FileTypeDto> viewFile_location();
	public FileTypeDto searchById(long id);
	public boolean searchFileType(String type) ;
	public boolean searchFileName(String name) ;
}
