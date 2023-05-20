package com.example.company.service;

import java.util.List;

import com.example.company.entity.menu;
import com.example.company.entity.roleMenuMapping;

public interface roleMenuMappingService {
	
	public List<roleMenuMapping> getAllRoleMenuMappings();
    public roleMenuMapping getRoleMenuMappingById(Long mappingId);
    public roleMenuMapping saveRoleMenuMapping(roleMenuMapping mapping);
    public void deleteRoleMenuMapping(Long mappingId);
	public List<menu> getMenuByRoleId(Long roleId);

}
