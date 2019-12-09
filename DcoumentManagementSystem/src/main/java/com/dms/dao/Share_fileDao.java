package com.dms.dao;

import java.util.List;

import com.dms.dto.MessageDto;
import com.dms.dto.NotiDTO;
import com.dms.dto.Share_fileDto;
import com.dms.entity.Share_files;

public interface Share_fileDao {
	public List<Share_files> viewAllShare_file();
	public Share_files searchShare_file(long id);
	public void deleteShare_file(Share_files share_file);
	public void saveOrUpdateShare_file(Share_files share_file);
	public long saveShare_file(Share_files share_file);
	public List<Share_files> receivedShareFile(long id);
	public List<Share_fileDto> sendedShareFile(long id);
	public List<NotiDTO> getNotiList(long userId);
	public void updateFileReceiveDate(long id,long userId);
	public List<Share_fileDto> getReceiveShareFiles(long id);
	public Share_fileDto getShare_file(long msgId, long userId) ;
	public Share_fileDto SearchSharefile(String name) ;
}
