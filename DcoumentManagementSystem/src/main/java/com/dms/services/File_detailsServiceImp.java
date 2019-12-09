package com.dms.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.dms.dao.File_detailsDao;
import com.dms.dao.File_locationDao;
import com.dms.dao.Share_fileDao;
import com.dms.dao.User_infoDao;
import com.dms.dao.User_loginDao;
import com.dms.dto.FileUpload;
import com.dms.dto.File_detailsDto;
import com.dms.dto.MessageDto;
import com.dms.dto.NotiDTO;
import com.dms.dto.Share_fileDto;
import com.dms.dto.User_profile;
import com.dms.entity.File_details;
import com.dms.entity.Share_files;
import com.dms.entity.User_info;
import com.dms.entity.User_login;
import com.dms.validator.FileUploadValidator;


@Service
@Transactional
public class File_detailsServiceImp implements File_detailsService{
	@Autowired 
	private FileUploadValidator fileValidator;
	@Autowired
	private File_locationDao file_locationDao;
	@Autowired
	private File_detailsDao file_detailsDao;
	@Autowired
	private User_detailsService user_detailService;
	@Autowired
	private Share_fileDao share_fileDao;
	@Autowired
	private User_infoDao user_infoDao;
	@Autowired 
	private ServletContext servletContext;
	public boolean checkError(FileUpload uploadedFile, BindingResult result) {
		// TODO Auto-generated method stub
		fileValidator.validate(uploadedFile, result);
		if (result.hasErrors()) {
			return false;
		}
		return true;
	}

	public File_details upload_File(FileUpload uploadedFile,long id) {
		// TODO Auto-generated method stub 
		InputStream inputStream = null;
		OutputStream outputStream = null;
		MultipartFile file = uploadedFile.getFile();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String fileName = dateFormat.format(date) + file.getOriginalFilename();
		String fileType = FilenameUtils.getExtension(fileName).toLowerCase();
		String path = file_locationDao.searchFile_path(fileType);
		File rootDir = new File( servletContext.getRealPath(path) );
		String realPath=rootDir.getAbsolutePath();
		System.out.println(fileName + fileType + path);
		File_details result=new File_details();
		try {
			inputStream = file.getInputStream();

			File newFile = new File(realPath+"//"+fileName);
			System.out.println(newFile);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			File_details file_details = new File_details();
			file_details.setTitle(uploadedFile.getTitle());
			file_details.setName( file.getOriginalFilename());
			file_details.setTypes(fileType);
			file_details.setPath(path+"//"+fileName);
			file_details.getUser_info().setId(id);
			result=file_detailsDao.saveOrUpdate(file_details);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	 
	public String upload_File(FileUpload uploadedFile,String name) {
		// TODO Auto-generated method stub
		InputStream inputStream = null;
		OutputStream outputStream = null;
		MultipartFile file = uploadedFile.getFile();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String fileName = dateFormat.format(date)+file.getOriginalFilename();
		String fileType=FilenameUtils.getExtension(fileName).toLowerCase();
		File rootDir = new File( servletContext.getRealPath("/resources/profiles") );
		String path=rootDir.getAbsolutePath();
		System.out.println(fileName+fileType+path);
		try {
			inputStream = file.getInputStream();

			File newFile = new File(path+"\\"+name);
			System.out.println(newFile);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public List<File_detailsDto> own_File() {
		// TODO Auto-generated method stub
		User_profile user=user_detailService.user_profile();
		List<File_details> ownFile=file_detailsDao.ownFile(user.getId());
		List<File_detailsDto> result=new ArrayList<File_detailsDto>();
		for(File_details u:ownFile) {
			File_detailsDto file_details=convertFile_detailsDtoBean(u);
			System.out.println(file_details.getName()+"fileName");
			result.add(file_details);
		}
		System.out.println(result.size()+"size of file");
		return result;
	}
	public File_detailsDto convertFile_detailsDtoBean(File_details input) {
		File_detailsDto result=new File_detailsDto();
		result.setId(input.getId());
		result.setPath(input.getPath());
		result.setUser_id(input.getUser_info().getId());
		result.setName(input.getName());
		result.setType(input.getTypes());
		result.setTitle(input.getTitle());
		return result;
	}
	public void save_Share_File(Share_fileDto share_file) {
		Share_files share=new Share_files();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String strDate = dFormat.format(new Date());  
			share.setSend_date( dateFormat.parse(strDate));
		} catch (ParseException e) {
		e.printStackTrace();
		}
		List<Long> receiverid=share_file.getReceiver();
		
		for(Long u : receiverid){
			for(Long i:share_file.getFileList()) {
			share.getReceiver_info().setId(u);
			share.getFile_detail().setId(i);
			System.out.println(receiverid.size()+""+u+"receiver id");
			share_fileDao.saveOrUpdateShare_file(share);
			}
		}
		
	}
	public void save_Share_FileDepartment(Share_fileDto share_file) {
		Share_files share=new Share_files();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String strDate = dFormat.format(new Date());  
			share.setSend_date( dateFormat.parse(strDate));
		} catch (ParseException e) {
		e.printStackTrace();
		}
		List<Long> receiverid=new ArrayList<Long>();
		for(Long i:share_file.getDepartmentList()) {
			List<User_info> userList=user_infoDao.searchWithDepartment(i);
			for(User_info u:userList) {
				receiverid.add(u.getId());
			}
		}
		for(Long u : receiverid){
			for(Long i:share_file.getFileList()) {
			share.getReceiver_info().setId(u);
			share.getFile_detail().setId(i);
			System.out.println(receiverid.size()+""+u+"receiver id");
			share_fileDao.saveOrUpdateShare_file(share);
			}
		}
		
	}

	@Override
	public List<Share_files> receiveShareFile(long id) {
		// TODO Auto-generated method stub
		return share_fileDao.receivedShareFile(id);
	}

	@Override
	public List<Share_fileDto> sendedShareFile(long id) {
		// TODO Auto-generated method stub
		return share_fileDao.sendedShareFile(id);
	}

	@Override
	public List<NotiDTO> getNotiList(long userId) {
		// TODO Auto-generated method stub
		return share_fileDao.getNotiList(userId);
	}

	@Override
	public void updateFileReceiveDate(long id, long userId) {
		// TODO Auto-generated method stub
		share_fileDao.updateFileReceiveDate(id, userId);
	}

	@Override
	public Share_fileDto getShare_files(long fileId, long userId) {
		// TODO Auto-generated method stub
		
		return share_fileDao.getShare_file(fileId, userId);
	}

	@Override
	public File_detailsDto viewFile(Long id) {
		// TODO Auto-generated method stub
		return file_detailsDao.viewFile(id);
	}

	@Override
	public List<File_details> searchFileName(long id,String name) {
		// TODO Auto-generated method stub
		return file_detailsDao.searchFileName(id,name);
	}

	@Override
	public List<File_detailsDto> searchByType(long id, String type) {
		// TODO Auto-generated method stub
		return file_detailsDao.searchByType(id, type);
	}

}
