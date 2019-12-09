package com.dms.dao;


import java.util.List;
import com.dms.dto.File_detailsDto;
import com.dms.entity.File_details;

public interface File_detailsDao {
	public File_details saveOrUpdate(File_details file_details);
	public List<File_details> ownFile(long id);
	public File_details searchById(long id);
	public File_detailsDto viewFile(Long id);
	public List<File_details> searchFileName(long id,String name);
	public List<File_details> searchShareFile(String search) ;
	public List<File_detailsDto> searchByType(long id,String type);
}
