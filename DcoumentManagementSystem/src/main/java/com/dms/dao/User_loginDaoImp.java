package com.dms.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.dms.entity.User_login;

@Repository
@org.springframework.transaction.annotation.Transactional
public class User_loginDaoImp implements User_loginDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public List<User_login> viewAllUser_login() {
		// TODO Auto-generated method stub
		List<User_login> list_user_login=sessionFactory.getCurrentSession().createCriteria(User_login.class).list();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User_login user_login=findUserByEmail(username);
		list_user_login.remove(user_login);		
		return list_user_login;
	}

	public User_login searchUser_login(User_login user_login) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User_login search_user_login=(User_login) session.get(User_login.class, user_login.getId());
		return search_user_login;
	}

	public void deleteUser_login(User_login user_login) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User_login delete_user_login=(User_login) session.get(User_login.class,user_login.getId());
		session.delete(delete_user_login);
		session.flush();
	}

	public void saveOrUpdateUser_login(User_login user_login) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(user_login);
	}
	public User_login findUserByEmail(String name) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User_login.class)
				.createAlias("role","r",JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("email", name));
		User_login user_login=(User_login) cr.uniqueResult();
		
		
		return user_login;
	}


	public User_login searchId(String email) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User_login.class);
		cr.add(Restrictions.eq("email", email));
		System.out.println(email+"user_ login search id function");
		User_login user_login=(User_login) cr.uniqueResult();
		return user_login;
	}
	
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User_login.class);
		cr.add(Restrictions.eq("email", email));
		System.out.println(email+"user_ login search id function");
		Integer count= cr.list().size();
		if(Long.valueOf(count)==0) {
		return true;
	}else
		return false;
	}

	@Override
	public String getNewPassword(String email) {
	// TODO Auto-generated method stub
	int min=1;
	int max=9;
	String new_password="";
	for(int i=0;i<8;i++) {
	int j=(int) (Math.random()*((max-min)+1))+min;
	new_password+=j;
	}
	User_login user=searchId(email);
	user.setPassword(bcryptEncoder.encode(new_password));
	saveOrUpdateUser_login(user);
	return new_password;
	}
}
