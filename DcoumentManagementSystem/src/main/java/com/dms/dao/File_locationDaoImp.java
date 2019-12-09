package com.dms.dao;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.dto.FileTypeDto;
import com.dms.dto.File_detailsDto;
import com.dms.entity.File_details;
import com.dms.entity.File_location;

@Repository
@org.springframework.transaction.annotation.Transactional
public class File_locationDaoImp implements File_locationDao{
	@Autowired private SessionFactory sessionFactory;
	@Autowired private ServletContext servletContext;
	
	public List<FileTypeDto> viewAllFile_location() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_location.class);
		cr.setProjection(Projections.projectionList()	
			      .add(Projections.property("id"), "id")
			      .add(Projections.property("file_type"),"type")
			      .add(Projections.property("location"),"location")
			      .add(Projections.property("name"),"name")
				);
		cr.setResultTransformer(Transformers.aliasToBean(FileTypeDto.class));
		List<FileTypeDto> view=(List<FileTypeDto>) cr.list();
		return view;
	}

	public String searchFile_path(String type) {
		// TODO Auto-generated method stub
		System.out.println(type+"search file path ");
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_location.class);
		cr.add(Restrictions.eq("file_type", type));
		File_location file=(File_location) cr.uniqueResult();
		String path=file.getLocation();
		return path;
	}

	public void deleteFile_location(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		File_location delete_file_location=(File_location) session.get(File_location.class,id);
		session.delete(delete_file_location);
		session.flush();
	}

	public void saveOrUpdateFile_location(File_location file_location) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(file_location);
	}

	@Override
	public File_location searchFile_location(String type) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_location.class);
		cr.add(Restrictions.eq("file_type", type));
		File_location file=(File_location) cr.uniqueResult();
		return file;
	}

	@Override
	public FileTypeDto searchById(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_location.class);
		cr.setProjection(Projections.projectionList()	
			      .add(Projections.property("id"), "id")
			      .add(Projections.property("file_type"),"type")
			      .add(Projections.property("location"),"location")
			      .add(Projections.property("name"),"name")
				);
		cr.setResultTransformer(Transformers.aliasToBean(FileTypeDto.class));
		cr.add(Restrictions.eq("id", id));
		FileTypeDto view=(FileTypeDto) cr.uniqueResult();
		return view;
	}

	@Override
	public boolean searchFileType(String type) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_location.class);
		cr.add(Restrictions.eq("file_type", type));
		List<File_location> fileList=cr.list();
		if(fileList.size()>0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean searchFileName(String name) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_location.class);
		cr.add(Restrictions.eq("name", name));
		List<File_location> fileList=cr.list();
		if(fileList.size()>1) {
			return false;
		}else {
			return true;
		}
	}
	
}
