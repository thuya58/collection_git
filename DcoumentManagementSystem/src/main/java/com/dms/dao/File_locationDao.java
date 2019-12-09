package com.dms.dao;

import java.util.List;

import com.dms.dto.FileTypeDto;
import com.dms.entity.File_location;
public interface File_locationDao {
	public List<FileTypeDto> viewAllFile_location();
	public String searchFile_path(String type);
	public void deleteFile_location(long file_location);
	public void saveOrUpdateFile_location(File_location file_location);
	public File_location searchFile_location(String type);
	public FileTypeDto searchById(long id);
	public boolean searchFileType(String type);
	public boolean searchFileName(String name);
}
