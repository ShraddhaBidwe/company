package com.example.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.company.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	 Users findByEmail(String email);
}
