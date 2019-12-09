 package com.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dms.dto.FileTypeDto;
import com.dms.services.FileTypeServices;
@Controller
public class FileTypeController {
	@Autowired
	private FileTypeServices fileTypeService;
	@RequestMapping(value="/fileType.htm")
	public String fileType(Model model) {
		 model.addAttribute("fileType",new FileTypeDto());   
		return "fileType";
	}
	@RequestMapping(value="/savefileType.htm")
	public String saveExtension(Model model,@ModelAttribute("fileType")FileTypeDto fileType) {
		if(fileTypeService.searchFileType(fileType.getType())& fileTypeService.searchFileName(fileType.getName())){
		fileTypeService.saveFile_location(fileType);
		return "redirect:/fileTypeList.htm";
		}else {

		    model.addAttribute("errorMsg", "File extension is already exist");
		    model.addAttribute("fileType",new FileTypeDto());   
			return "fileType";
		}
	}
	@RequestMapping(value="/fileTypeList.htm")
	public String viewFile_location(Model model) {
		model.addAttribute("fileTypeList",fileTypeService.viewFile_location());
		return "fileTypeList";
	}
	@RequestMapping(value="/updateFileType.htm/{id}")
	public String updateFile_location(Model model,@ModelAttribute("id")long id) {
		model.addAttribute("fileType",new FileTypeDto()); 
		model.addAttribute("file_type",fileTypeService.searchById(id));
		return "updateFileType";
	}
	@RequestMapping(value="/changefileType.htm")
	public String updateFile(Model model,@ModelAttribute("fileType")FileTypeDto fileType) {
		model.addAttribute("fileType",new FileTypeDto()); 
		fileTypeService.updateFile_location(fileType);
		return "redirect:/fileTypeList.htm";
	}
	@RequestMapping(value="/deleteFileType.htm/{id}")
	public String deleteFile_location(Model model,@ModelAttribute("id")long id) {
		model.addAttribute("fileType",new FileTypeDto()); 
		model.addAttribute("file_type",fileTypeService.searchById(id));
		return "deleteFileType";
	}
	@RequestMapping(value="/deletefileType.htm")
	public String deleteFile(Model model,@ModelAttribute("fileType")FileTypeDto fileType) {
		model.addAttribute("fileType",new FileTypeDto()); 
		fileTypeService.deleteFile_location(fileType);;
		return "redirect:/fileTypeList.htm";
	}
	
}
