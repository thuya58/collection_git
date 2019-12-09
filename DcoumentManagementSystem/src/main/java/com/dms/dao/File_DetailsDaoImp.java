package com.dms.dao;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.dto.File_detailsDto;
import com.dms.entity.File_details;
@Repository
@org.springframework.transaction.annotation.Transactional
public class File_DetailsDaoImp implements File_detailsDao{
	@Autowired
	private SessionFactory sessionFactory;


	public File_details saveOrUpdate(File_details file_details) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		long output=(long) session.save(file_details);
		return searchById(output);
	}
	
	@Override
	public List<File_details> ownFile(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_details.class);
		cr.add(Restrictions.eq("user_info.id", id));
		List<File_details> own_file=cr.list();
		return own_file;
	}


	@Override
	public File_details searchById(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_details.class);
		cr.add(Restrictions.eq("id", id));
		File_details result=(File_details) cr.uniqueResult();
		return result;
	}

	@Override
	public File_detailsDto viewFile(Long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_details.class)
				.createAlias("user_info", "s", JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList()	
			      .add(Projections.property("name"), "name")
			      .add(Projections.property("path"),"path")
			      .add(Projections.property("s.name"),"owner")
				);
		cr.setResultTransformer(Transformers.aliasToBean(File_detailsDto.class));
		cr.add(Restrictions.eq("id", id));
		//File_details view=cr.list();
		return (File_detailsDto)cr.uniqueResult();
		}
	@Override
	public List<File_details> searchShareFile(String search) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(File_details.class);
		c.add(Restrictions.like("name", "%"+search+"%"));
		List<File_details> searchfile=c.list();
		return searchfile;
	}

	@Override
	public List<File_details> searchFileName(long id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File_detailsDto> searchByType(long id,String type) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(File_details.class)
				.createAlias("user_info", "s", JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList()	
				.add(Projections.property("id"), "id")
			      .add(Projections.property("name"), "name")
			      .add(Projections.property("path"),"path")
			      .add(Projections.property("s.name"),"owner")
			      .add(Projections.property("title"), "title")
			      .add(Projections.property("types"), "type")
				);
		cr.setResultTransformer(Transformers.aliasToBean(File_detailsDto.class));
		cr.add(Restrictions.eq("s.id", id));
		cr.add(Restrictions.eq("types", type));
		List<File_detailsDto>  view=cr.list();
		return view;
	}
	
}
