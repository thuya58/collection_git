package com.dms.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;
import com.dms.entity.User_login;

@Repository
@Transactional
public class User_infoDaoImp implements User_infoDao{
	@Autowired
	private SessionFactory sessionFactory;

	public List<User_info> viewAllUser_info() {
		// TODO Auto-generated method stub
		List<User_info> list_user_info=sessionFactory.getCurrentSession().createCriteria(User_info.class).list();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getName();
		User_info user_info=findByUserName(username);
		list_user_info.remove(user_info);		
		return list_user_info;
	}

	public User_info searchUser_info(long  id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User_info search_user_info=session.get(User_info.class, id);
		return search_user_info;
	}

	public void deleteUser_info(User_info user_info) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User_info delete_user_info=session.get(User_info.class,user_info.getId());
		session.delete(delete_user_info);
		session.flush();
	}

	public void saveOrUpdateUser_info(User_info user_info) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(user_info);
	}

	public List<User_info> searchId(String user_info) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User_info.class);
		cr.add(Restrictions.eq("name", user_info));
		List<User_info> user=cr.list();
		return user;
	}

	public User_info search_User(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User_info.class).createAlias("user_login","r",JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("user_login.id", id));
		User_info user=(User_info) cr.uniqueResult();
		return user;
	}
	public User_info findByUserName(String name) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User_info.class).createAlias("user_login","r",JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("name", name));
		User_info user=(User_info) cr.uniqueResult();
		return user;
	}

	@Override
	public void updateUser(User_registerDto user_register) {
	Session session=sessionFactory.getCurrentSession();
	SQLQuery query= session.createSQLQuery("update user_info set department_id =:department where id=:id");
	query.setParameter("department", user_register.getDepartment_id());
	//query.setParameter("loginId", user_register.getRole_id());
	query.setParameter("id", user_register.getId());
	int status=query.executeUpdate();
	System.out.println(status);
	}

	@Override
	public List<User_info> searchWithDepartment(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User_info.class);
		cr.add(Restrictions.eq("department.id", id));
		List<User_info> user=cr.list();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getName();
		User_info user_info=findByUserName(username);
		user.remove(user_info);		
		return user;
	}
}
