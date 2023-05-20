package com.example.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.company.entity.UserRole;


public interface RoleRepository extends JpaRepository<UserRole, Long>{

}
