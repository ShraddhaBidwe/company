package com.example.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.company.entity.menu;

@Repository
public interface menuRepository extends JpaRepository<menu, Long> {

//	void updateById(Long menuId);
	
}
