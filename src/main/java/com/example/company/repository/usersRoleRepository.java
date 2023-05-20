package com.example.company.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.company.entity.UserRole;


@Repository
public interface usersRoleRepository extends JpaRepository<UserRole, Long> {

//	UserRole save(UserRole userRole);
//	void updateById(Long roleId);
	
}
