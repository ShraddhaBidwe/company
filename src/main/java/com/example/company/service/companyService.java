package com.example.company.service;

import java.util.List;
import java.util.Optional;

import com.example.company.entity.UserRole;
import com.example.company.request.companyRequest;
import com.example.company.response.companyResponse;

public interface companyService {
	
	public List<companyResponse> getAllCompanies() throws Exception;
	public Optional<companyResponse> getCompanyById(Long companyId) throws Exception;
	public String updateCompany(Long companyId, companyRequest request) throws Exception;
    public String deleteCompany(Long companyId) throws Exception;
    public companyResponse createCompany(companyRequest companyRequest) throws Exception;
//	String updateCompany(Long companyId, companyRequest request, UserRole role) throws Exception;

}
