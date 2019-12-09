package com.dms.dao;

import java.util.List;

import com.dms.entity.Department;
public interface DepartmentDao {
	public List<Department> viewAllDepartment();
	public Department searchDepartment(long id);
	public void deleteDepartment(Department department);
	public void saveOrUpdateDepartment(Department department);
}
