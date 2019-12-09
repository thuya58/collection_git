package com.dms.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.entity.User_role;

@Repository
@org.springframework.transaction.annotation.Transactional
public class RoleDaoImp implements RoleDao{
	@Autowired
	private SessionFactory sessionFactory;

	public List<User_role> viewAllRole() {
		// TODO Auto-generated method stub
		List<User_role> list_role=sessionFactory.getCurrentSession().createCriteria(User_role.class).list();
		return list_role;
	}

	public User_role searchRole(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User_role search_role=(User_role) session.get(User_role.class, id);
		
		return search_role;
	}

	public void deleteRole(User_role role) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User_role delete_role=(User_role) session.get(User_role.class,role.getId());
		session.delete(delete_role);
		session.flush();
	}

	public void saveOrUpdateRole(User_role role) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(role);
	}

}
