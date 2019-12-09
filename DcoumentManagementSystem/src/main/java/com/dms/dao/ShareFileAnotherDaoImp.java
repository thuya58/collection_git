package com.dms.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dms.entity.Share_files;
import com.dms.entity.User_info;
import com.dms.entity.User_login;
@Repository
@Transactional
public class ShareFileAnotherDaoImp implements ShareFileAnotherDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Share_files> shareFile(long id) {
		// TODO Auto-generated method stub
		Session session=getCurrentSession();
		Criteria c = session.createCriteria(User_info.class);
		c.add(Restrictions.eq("id", id));
		User_info user_info=(User_info) c.uniqueResult();
		Criteria ca = session.createCriteria(Share_files.class);
		ca.add(Restrictions.eq("receiver_info.id", user_info.getId()));
		return ca.list();	
		
	}
	@Override
	public List<Share_files> shareFileAnother(long id) {
		// TODO Auto-generated method stub
         Session session=getCurrentSession();
		Criteria c = session.createCriteria(User_info.class);
		c.add(Restrictions.eq("id", id));
		User_info user_info=(User_info) c.uniqueResult();
		Criteria ca = session.createCriteria(Share_files.class)
				.createAlias("file_detail", "f", JoinType.LEFT_OUTER_JOIN)
				.createAlias("f.user_info", "s", JoinType.LEFT_OUTER_JOIN)
				;
		ca.add(Restrictions.eq("s.id", user_info.getId()));
		return ca.list();
	}

}