package com.example.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.company.entity.company;

@Repository
public interface companyRepository extends JpaRepository<company, Long>  {

	List<company> findAll();
	List<company> findByCompanyId(Long companyId);
//	Optional<company> findById(Long companyId);
	Optional<company> findById(Long id);
	company findByCompanyName(String companyName);
}
