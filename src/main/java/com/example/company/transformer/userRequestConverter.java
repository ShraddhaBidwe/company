package com.example.company.transformer;

import com.example.company.entity.Users;
import com.example.company.request.userRequest;

public class userRequestConverter {
	
	public static Users postUsersEntity(userRequest userRequest) {
		Users user=new Users();
		user.setUserId(userRequest.getUserId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
//		user.setType(userRequest.getType()); 
		user.setEmail(userRequest.getEmail()); 
		user.setPassword(userRequest.getPassword());
//		user.setCompanyId(userRequest.getCompanyId());
		user.setDeleted(userRequest.isDeleted());
//		user.setCompany(userRequest.getCompany());
		user.setRole(userRequest.getRole());
		return user;
	}

}
