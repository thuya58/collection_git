package com.dms.dao;

import java.util.List;
import com.dms.entity.Share_files;

public interface ShareFileAnotherDao {
	public List<Share_files> shareFile(long id);
	public List<Share_files> shareFileAnother(long id);

}