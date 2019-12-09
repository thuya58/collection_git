package com.dms.services;

import java.util.List;

import org.springframework.validation.BindingResult;
import com.dms.dto.FileUpload;
import com.dms.dto.File_detailsDto;
import com.dms.dto.MessageDto;
import com.dms.dto.NotiDTO;
import com.dms.dto.Share_fileDto;
import com.dms.entity.File_details;
import com.dms.entity.Share_files;
public interface File_detailsService {
	public boolean checkError(FileUpload uploadedFile,BindingResult result);
	public  File_details  upload_File(FileUpload uploadedFile,long id);
	public String upload_File(FileUpload uploadedFile,String name);
	public List<File_detailsDto> own_File();
	public void save_Share_File(Share_fileDto share_file);
	public void save_Share_FileDepartment(Share_fileDto share_file);
	public List<Share_files> receiveShareFile(long id);
	public List<Share_fileDto> sendedShareFile(long id);
	public List<NotiDTO> getNotiList(long userId);
	public void updateFileReceiveDate(long id,long userId);
	public Share_fileDto getShare_files(long fileId, long userId);
	public File_detailsDto viewFile(Long id);
	public List<File_details> searchFileName(long id,String name);
	public List<File_detailsDto> searchByType(long id,String type);
}
