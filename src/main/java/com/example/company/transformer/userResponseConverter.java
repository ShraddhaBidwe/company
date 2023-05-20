package com.example.company.transformer;

import com.example.company.entity.Users;
import com.example.company.response.userResponse;

public class userResponseConverter {
	
	public static userResponse convertToResponse(Users user) {
		 userResponse userResponse = new userResponse();
		 userResponse.setUserId(user.getUserId());
		 userResponse.setFirstName(user.getFirstName());
		 userResponse.setLastName(user.getLastName());
//		 userResponse.setType(user.getType()); 
		 userResponse.setEmail(user.getEmail()); 
		 userResponse.setPassword(user.getPassword());
//		 userResponse.setCompanyId(user.getCompany().getCompanyId());
		 userResponse.setDeleted(user.isDeleted());
//		 userResponse.setCompany(user.getCompany());
		 userResponse.setRole(user.getRole());
	        return userResponse;
	    }

}
