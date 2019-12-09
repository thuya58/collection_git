package com.dms.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dms.dao.DepartmentDao;
import com.dms.dao.File_detailsDao;
import com.dms.dto.FileUpload;
import com.dms.dto.File_detailsDto;
import com.dms.dto.NotiDTO;
import com.dms.dto.Share_fileDto;
import com.dms.dto.User_profile;
import com.dms.entity.File_details;
import com.dms.entity.Share_files;
import com.dms.entity.User_info;
import com.dms.services.File_detailsService;
import com.dms.services.ShareFileAnotherService;
import com.dms.services.User_detailsService;
import com.dms.services.User_infoService;
import com.dms.validator.FileUploadValidator;

@Controller
public class FileController {
	@Autowired 
	private User_detailsService user_detailsService;
	@Autowired
	private User_infoService user_infoService;
	@Autowired 
	private File_detailsService file_detailsServices;
	@Autowired 
	private FileUploadValidator fileValidator;
	@Autowired 
	private User_detailsService user_detailsDao;
	@Autowired 
	private File_detailsDao file_detailsDao;
	@Autowired
	private ShareFileAnotherService sharefile;
	@Autowired 
	private DepartmentDao departmentDao;
	@InitBinder
	protected void intiBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		
	}
	@RequestMapping(value="/sharefile.htm")
	public String My_File(Model model){
		User_profile user=user_detailsService.user_profile();
		model.addAttribute("userList",user_infoService.viewAllUser_info());
		model.addAttribute("share_fileDto",new Share_fileDto());
		model.addAttribute("details_list",file_detailsDao.ownFile(user.getId()));
		model.addAttribute("department_list",departmentDao.viewAllDepartment());
		return "sharefile";
	}
	@RequestMapping(value="/shareFile_department.htm")
	public String ShareWithDepartment(Model model){
		User_profile user=user_detailsService.user_profile();
		model.addAttribute("share_fileDto",new Share_fileDto());
		model.addAttribute("details_list",file_detailsDao.ownFile(user.getId()));
		model.addAttribute("department_list",departmentDao.viewAllDepartment());
		return "shareFile_department";
	}
	@RequestMapping(value="/file_upload.htm")
	public String file_upload(Model model){
		model.addAttribute("uploadedFile",new FileUpload());
		return "fileuploadform";
		
	}
	@RequestMapping(value="/ajax/send_file")
	public ResponseEntity<Object>  UploadFile(@RequestParam("file") MultipartFile file){
		System.out.println("this is in controller");
		FileUpload uploaded=new FileUpload();
		uploaded.setFile(file);
		File_details fDetail=new File_details();
		User_profile user = user_detailsService.user_profile();
		fDetail=file_detailsServices.upload_File(uploaded, user.getId());
		return new ResponseEntity<>(fDetail,HttpStatus.OK);
	}
	@RequestMapping(value="/uploadFile.htm")
	public String uploadFile(Model model,@ModelAttribute("uploaded_file")FileUpload uploaded_file,BindingResult result){
		fileValidator.validate(uploaded_file, result);
		User_profile user = user_detailsService.user_profile();
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "fileuploadform";
		} else {

			file_detailsServices.upload_File(uploaded_file, user.getId());
			return "redirect:/myFile.htm";
		}
	}
	@RequestMapping(value="/viewByType.htm/{imageList}", method = RequestMethod.GET)
	public String viewListTypes(Model model,@PathVariable(value = "imageList") List<Share_files> imageList){
		model.addAttribute("ownFile",imageList);
		return "myfile";
	}
	
	@RequestMapping(value="/myFile.htm")
	public String myFile(Model model){
		model.addAttribute("ownFile",file_detailsServices.own_File());
		return "myfile";
	}
	
	@RequestMapping(value = "/imagesend.htm/{id}", method = RequestMethod.GET)
	  public String fileSend(Model model, @PathVariable(value = "id") Long id) {
	  String fileExtentions = ".exe,.dmg,.jar";
	  File_detailsDto file_detailsDto=file_detailsServices.viewFile(id);
	  String fileName=file_detailsDto.getName();
	  
	  int lastIndex = fileName.lastIndexOf('.'); 
	  String substring=fileName.substring(lastIndex, fileName.length());
	  boolean result=(!fileExtentions.contains(substring)) ;
	  model.addAttribute("Name",file_detailsDto.getName());
	  model.addAttribute("path",file_detailsDto.getPath());
	  if(result  & (substring.equals(".jpg")|substring.equals(".png"))) {
	  model.addAttribute("imageName",file_detailsDto.getName());
	  model.addAttribute("path",file_detailsDto.getPath());
	  return "imagesend"; 
	  }
	  else if(result  & substring.equals(".mp4")){
		  model.addAttribute("Name",file_detailsDto.getName());
		  model.addAttribute("path",file_detailsDto.getPath());
	  return "videosend"; 
	  }
	  else if(result  & substring.equals(".mp3")){
		  model.addAttribute("Name",file_detailsDto.getName());
		  model.addAttribute("path",file_detailsDto.getPath());
		  return "audiosend"; 
		  }
	  else if(result  & substring.equals(".pdf")){
		  model.addAttribute("Name",file_detailsDto.getName());
		  model.addAttribute("path",file_detailsDto.getPath());
		  return "pdfsend"; 
		  }
	  else if(result  & substring.equals(".docx")){
		  model.addAttribute("Name",file_detailsDto.getName());
		  return "wordsend"; 
		  }
	  else if(result  & substring.equals(".xlsx")){
		  model.addAttribute("Name",file_detailsDto.getName());
		  return "excelsend"; 
		  }
	  return "wordsend";
	  }
	
	
	@RequestMapping(value="/savesharefile.htm", method=RequestMethod.POST )
	public String save_Share_File(Model model,@ModelAttribute("share_fileDto")Share_fileDto share_file){
		file_detailsServices.save_Share_File(share_file);
		User_profile user=user_detailsService.user_profile();
		model.addAttribute("sharefile_to_another_list",sharefile.shareFileAnother(user.getId()));
		return "share_file_to_another";
	}
	@RequestMapping(value="/savesharefile_department.htm", method=RequestMethod.POST )
	public String save_Share_FileDepartment(Model model,@ModelAttribute("share_fileDto")Share_fileDto share_file){
		System.out.println(share_file.getFile_id()+"this is a id");
		file_detailsServices.save_Share_FileDepartment(share_file);
		User_profile user=user_detailsService.user_profile();
		model.addAttribute("sharefile_to_another_list",sharefile.shareFileAnother(user.getId()));
		return "share_file_to_another";
	}
	@RequestMapping(value="/ajax/getNotiList",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getNoti(){
		User_profile user = user_detailsService.user_profile();
		List<NotiDTO> notiList=file_detailsServices.getNotiList(user.getId());
		return new ResponseEntity<>(notiList,HttpStatus.OK);
	}
	@RequestMapping(value="/viewFileDetail.htm/{id}")
	public String viewIncomeFileDetail(Model model,@ModelAttribute("id")long id){
		System.out.println(id+"iddddddddddd");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User_info user=user_detailsDao.search_User_info(username);
		Share_fileDto fil=file_detailsServices.getShare_files(id, user.getId());
		if(fil.getReceive_date()==null)
		 file_detailsServices.updateFileReceiveDate(id,user.getId());
		 model.addAttribute("share_file",fil);
		System.out.println(fil.getId()+"iddddd");
		return "viewfileDetail";
	}
	  @RequestMapping(value="/searchfile",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		  public @ResponseBody List<File_details> searchFile(@RequestParam(value="searchFile") String search,Model model)
		 
		  { 
				model.addAttribute("searchFile", new File_details());
			List<File_details> searchfile=file_detailsDao.searchShareFile(search);
		  return searchfile;
		  }
}
