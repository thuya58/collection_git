package com.dms.services;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dms.dao.File_locationDao;
import com.dms.dto.FileTypeDto;
import com.dms.entity.File_location;
@Service
@Transactional
public class FileTypeServicesImp implements FileTypeServices{
	@Autowired 
	private ServletContext servletContext;
	@Autowired
	private File_locationDao file_locationDao;
	
	@Override
	public boolean createFile(String name) {
		// TODO Auto-generated method stub  
		String path="resources/data/";
		File rootDir = new File( servletContext.getRealPath(path) );
		String realPath=rootDir.getAbsolutePath();
		String realfile=realPath+"\\"+name;
		System.out.println(realfile+realPath);
		File file = new File(realfile);
		  boolean result = false;
		// if the directory does not exist, create it
		if (!file.exists()) {
		    System.out.println("creating directory: " + file.getName());
		    result = true;
		    try{
		    	file.mkdir();
		    } 
		    catch(SecurityException se){
		        System.out.println("File creating error");
		    }
		    return result;
		}else {
			return result;
		}
	}

	@Override
	public boolean renameFile(String newName,String oldName) {
		// TODO Auto-generated method stub
		String path="resources/data/";
		File rootDir = new File( servletContext.getRealPath(path) );
		String realPath=rootDir.getAbsolutePath();
		File oldtDir = new File( servletContext.getRealPath(oldName) );
		String oldPath=oldtDir.getAbsolutePath();
		File oldFile = new File(oldPath);
		File newfile=new File(realPath+"\\"+newName);
		boolean result=false;
		if (oldFile.renameTo(newfile)) {
		    result=true;
		}
		return result;
	}

	@Override
	public boolean deleteFile(String name) {
		// TODO Auto-generated method stub
		File oldtDir = new File( servletContext.getRealPath(name) );
		String getPath=oldtDir.getAbsolutePath();
		File index = new File(getPath);
		boolean result=false;
		boolean check=index.exists();
		if (check) {
		String[]entries = index.list();
		for(String s: entries){
		    File currentFile = new File(index.getPath(),s);
		    currentFile.delete();
		}
		index.delete();
		result=true;
		}else {
			
		}
		return result;
	}

	@Override
	public void saveFile_location(FileTypeDto name) {
		// TODO Auto-generated method stub
		File_location savefile=new File_location();
		savefile.setFile_type(name.getType());
		savefile.setLocation("/resources/data/"+name.getName());
		savefile.setName(name.getName());
		file_locationDao.saveOrUpdateFile_location(savefile);
		createFile(name.getName());
	}

	@Override
	public void updateFile_location(FileTypeDto name) {
		// TODO Auto-generated method stub
		File_location savefile=new File_location();
		savefile.setId(name.getId());
		savefile.setFile_type(name.getNewType());
		savefile.setLocation("/resources/data/"+name.getNewName());
		savefile.setName(name.getNewName());
		file_locationDao.saveOrUpdateFile_location(savefile);
		renameFile(name.getNewName(), name.getName());
	}

	@Override
	public void deleteFile_location(FileTypeDto fileTypeDto) {
		// TODO Auto-generated method stub
		file_locationDao.deleteFile_location(fileTypeDto.getId());
		deleteFile(fileTypeDto.getLocation());
	}

	@Override
	public List<FileTypeDto> viewFile_location() {
		// TODO Auto-generated method stub
		return file_locationDao.viewAllFile_location();
	}

	@Override
	public FileTypeDto searchById(long id) {
		// TODO Auto-generated method stub
		return file_locationDao.searchById(id);
	}

	@Override
	public boolean searchFileType(String type) {
		// TODO Auto-generated method stub
		return file_locationDao.searchFileType(type);
	}

	@Override
	public boolean searchFileName(String name) {
		// TODO Auto-generated method stub
		return file_locationDao.searchFileName(name);
	}

}
