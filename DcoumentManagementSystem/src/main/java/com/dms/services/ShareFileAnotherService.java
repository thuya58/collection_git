package com.dms.services;

import java.util.List;

import com.dms.entity.Share_files;

public interface ShareFileAnotherService {
	public List<Share_files> shareFile(long userName);
	public List<Share_files> shareFileAnother(long userName);
}