package com.example.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.company.entity.roleMenuMapping;

@Repository
public interface roleMenuMappingRepository extends JpaRepository<roleMenuMapping, Long> {
	
	List<roleMenuMapping> findByRoleId(Long roleId);
}
