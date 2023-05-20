package com.example.company.responce_transform;

import com.example.company.entity.Users;
import com.example.company.response.userResponse;


public class UserResponseConverter {
	 public static userResponse convertToResponse(Users user) {
		 userResponse userResponse = new userResponse();
		 userResponse.setUserId(user.getUserId());
		 userResponse.setFirstName(user.getFirstName());
		 userResponse.setLastName(user.getLastName());
		 userResponse.setEmail(user.getEmail()); 
		 userResponse.setPassword(user.getPassword()); 
//         userResponse.setUserRole(user.getUserId());
		 userResponse.setVerificationEnabled(user.isVerificationEnabled());
	        return userResponse;
	    }
}
