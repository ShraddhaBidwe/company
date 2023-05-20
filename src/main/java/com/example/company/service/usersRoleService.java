package com.example.company.service;

import java.util.List;

import com.example.company.entity.UserRole;

public interface usersRoleService {
	
	public List<UserRole> getAllRoles();
    public UserRole getRoleById(Long roleId);
    public UserRole saveRole(UserRole role);
    public void deleteRole(Long roleId);
    public UserRole updateRole(Long roleId,UserRole role);

}
