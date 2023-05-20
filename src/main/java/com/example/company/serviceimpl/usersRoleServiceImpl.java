package com.example.company.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.company.entity.UserRole;
import com.example.company.repository.usersRoleRepository;
import com.example.company.service.usersRoleService;


@Service
public class usersRoleServiceImpl implements usersRoleService {

	@Autowired usersRoleRepository roleRepository;

    @Override
    public List<UserRole> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public UserRole getRoleById(Long roleId) {
        Optional<UserRole> role = roleRepository.findById(roleId);
        return role.orElse(null);
    }
        
    
    @Override
    public UserRole saveRole(UserRole role) {
        return roleRepository.save(role);
    }
    
//    @Override
//    public String updateRole(Long roleId,UserRole role) {
////        return roleRepository.updateById(roleId);
//    	return "updated successfully";
//    }
    
    
    @Override
    public UserRole updateRole(Long roleId, UserRole role) {
        Optional<UserRole> existingRole = roleRepository.findById(roleId);
        if (existingRole.isPresent()) {
            UserRole updatedRole = existingRole.get();
            updatedRole.setRoleName(role.getRoleName());
            return roleRepository.save(updatedRole);
        } else {
            return null; 
        }
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }
	
}
