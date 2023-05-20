package com.example.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.entity.menu;
import com.example.company.entity.roleMenuMapping;
import com.example.company.service.roleMenuMappingService;

@RestController
@RequestMapping("/rolemenumappings")
public class roleMenuMappingController {
	
	@Autowired
    private roleMenuMappingService service;

    @GetMapping("/getall")
    public List<roleMenuMapping> getAllRoleMenuMappings() {
        return service.getAllRoleMenuMappings();
    }

    @GetMapping("/getById/{roleId}")
    public List<menu> getMenuByRoleId(@PathVariable Long roleId) {
        return service.getMenuByRoleId(roleId);
    }

    @PostMapping("/add")
    public roleMenuMapping saveRoleMenuMapping(@RequestBody roleMenuMapping mapping) {
        return service.saveRoleMenuMapping(mapping);
    }

    @DeleteMapping("/delete/{mappingId}")
    public void deleteRoleMenuMapping(@PathVariable Long mappingId) {
    	service.deleteRoleMenuMapping(mappingId);
    }
    
    

}
