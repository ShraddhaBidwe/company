package com.example.company.transformer;

import com.example.company.entity.company;
import com.example.company.request.companyRequest;

public class companyRequestConverter {
	
	public static company postCompanyEntity(companyRequest company) {
		
        company companyEntity = new company();
        
        companyEntity.setCompanyId(company.getCompanyId());
        companyEntity.setCompanyName(company.getCompanyName());
        companyEntity.setEmailId(company.getEmailId());
        companyEntity.setPhoneNumber(company.getPhoneNumber());
        companyEntity.setIsDeleted(company.getIsDeleted());
        companyEntity.setAddress(company.getAddress());
        companyEntity.setRole(company.getRole());
        companyEntity.setUsers(company.getUsers());

        return companyEntity;
    }

	public static company updateCompanyEntity(company companyEntity, companyRequest company) {
		companyEntity.setCompanyId(company.getCompanyId());
		companyEntity.setCompanyName(company.getCompanyName());
		companyEntity.setEmailId(company.getEmailId());
		companyEntity.setPhoneNumber(company.getPhoneNumber());
		companyEntity.setIsDeleted(company.getIsDeleted());
        companyEntity.setAddress(company.getAddress());
		companyEntity.setRole(company.getRole());
		companyEntity.setUsers(company.getUsers());
        return companyEntity;
	}
	

}
