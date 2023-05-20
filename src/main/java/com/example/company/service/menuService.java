package com.example.company.service;

import java.util.List;

import com.example.company.entity.menu;


public interface menuService {

	public List<menu> getAllMenus();
    public menu getMenuById(Long menuId);
    public menu saveMenu(menu menu);
    public menu updateMenu(Long menuId, menu menu);
    public void deleteMenu(Long menuId);
	
}
