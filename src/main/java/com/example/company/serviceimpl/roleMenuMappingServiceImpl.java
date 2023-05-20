package com.example.company.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.company.entity.UserRole;
import com.example.company.entity.menu;
import com.example.company.entity.roleMenuMapping;
import com.example.company.repository.menuRepository;
import com.example.company.repository.roleMenuMappingRepository;
import com.example.company.service.roleMenuMappingService;

@Service
public class roleMenuMappingServiceImpl implements roleMenuMappingService {
	
	@Autowired
    private roleMenuMappingRepository repository;
	
	@Autowired
    private menuRepository menuRepository;

    @Override
    public List<roleMenuMapping> getAllRoleMenuMappings() {
        return repository.findAll();
        
    }

    @Override
    public roleMenuMapping getRoleMenuMappingById(Long mappingId) {
        Optional<roleMenuMapping> mapping = repository.findById(mappingId);
        return mapping.orElse(null);
    }

    @Override
    public roleMenuMapping saveRoleMenuMapping(roleMenuMapping mapping) {
        return repository.save(mapping);
    }

    @Override
    public void deleteRoleMenuMapping(Long mappingId) {
    	repository.deleteById(mappingId);
    }
    
//    @Override
    public List<menu> getMenuByRoleId(Long roleId) {
    	List<roleMenuMapping> mappingList = repository.findByRoleId(roleId);
    	List<menu> menuListById = new ArrayList<>();
        for(roleMenuMapping mapping: mappingList) {
        	menu existingMenu = menuRepository.findById(mapping.getMenuId()).orElseThrow(() ->  new RuntimeException("No Menu Found"));
        	menuListById.add(existingMenu);
        }
    	System.out.println(menuListById);
        return menuListById ;
    }

    
    
//    @Autowired
//    private menuRepository menuRepository;
//    
//    public void addMenuToRole(Long roleId, Long menuId) {
//        UserRole role = roleRepository.findById(roleId).orElseThrow(() -> new EntityNotFoundException("Role not found"));
//        menu menu = menuRepository.findById(menuId).orElseThrow(() -> new EntityNotFoundException("Menu not found"));
//        roleMenuMapping roleMenuMapping = new roleMenuMapping();
//        roleMenuMapping.setRole(role);
//        roleMenuMapping.setMenu(menu);
//        role.getRoleMenuMappings().add(roleMenuMapping);
//        repository.save(role);
//    }

}
