package com.dms.dao;

import java.util.List;

import com.dms.entity.User_role;
public interface RoleDao {
	public List<User_role> viewAllRole();
	public User_role searchRole(long id);
	public void deleteRole(User_role role);
	public void saveOrUpdateRole(User_role role);
}
