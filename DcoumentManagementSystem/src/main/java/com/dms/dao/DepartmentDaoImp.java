package com.dms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.entity.Department;
  
@Repository
@org.springframework.transaction.annotation.Transactional
public class DepartmentDaoImp implements DepartmentDao{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Department> viewAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> list_department=sessionFactory.getCurrentSession().createCriteria(Department.class).list();
		System.out.println(list_department);
		return list_department;
	}

	public Department searchDepartment(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Department search_department=(Department) session.get(Department.class,id);
		
		return search_department;
	}

	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Department delete_department=(Department) session.get(Department.class,department.getId());
		session.delete(delete_department);
		session.flush();
	}

	public void saveOrUpdateDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(department);
	}
}
