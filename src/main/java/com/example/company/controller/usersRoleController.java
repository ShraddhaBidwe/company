package com.example.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.entity.UserRole;
import com.example.company.service.usersRoleService;

@RestController
@RequestMapping("/roles")
public class usersRoleController {
	
	@Autowired
    private usersRoleService roleService;

    @GetMapping("/getall")
    public List<UserRole> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{roleId}")
    public UserRole getRoleById(@PathVariable Long roleId) {
        return roleService.getRoleById(roleId);
    }

    @PostMapping("/add")
    public UserRole saveRole(@RequestBody UserRole role) {
        return roleService.saveRole(role);
    }
    
    
    @PutMapping("/update/{roleId}")
    public String updateRole(@PathVariable Long roleId, @RequestBody UserRole role) {
        roleService.updateRole(roleId, role);
        return "Role updated successfully.";
    }
   
    @DeleteMapping("/delete/{roleId}")
    public String deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
        return "Role deleted successfully.";
    }

}
