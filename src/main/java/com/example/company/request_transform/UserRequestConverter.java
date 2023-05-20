package com.example.company.request_transform;

import java.util.List;
import java.util.stream.Collectors;

import com.example.company.entity.Users;
import com.example.company.request.userRequest;




public class UserRequestConverter {


	public static Users updateEntity(Users user, userRequest userRequest) {
		user.setUserId(userRequest.getUserId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail()); 
		user.setPassword(userRequest.getPassword());
		user.setDeleted(userRequest.isDeleted());
//		user.setRole(userRequest.getRole());

//		user.setUserName(userRequest.getUserName());
//       user.setVerificationEnabled(userRequest.isVerificationEnabled());
		return user;
	}

	public static Users toEntity(userRequest userRequest) {
		Users user=new Users();
		user.setUserId(userRequest.getUserId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
//		user.setType(userRequest.getType()); 
		user.setEmail(userRequest.getEmail()); 
		user.setPassword(userRequest.getPassword());
//		user.setCompany(userRequest.getCompany());
        user.setDeleted(userRequest.isDeleted());
//        user.setUserName(userRequest.getUserName());
//        user.setRole(userRequest.getRole());
//        user.setVerificationEnabled(userRequest.isVerificationEnabled());
		return user;
	}

	public static List<Users> toEntity(List<Users> userList) {
		  return userList.stream()
			        .map(userRequest -> {
			            Users user = new Users();
	
			            user.setUserId(userRequest.getUserId());
			            user.setFirstName(userRequest.getFirstName());
			            user.setLastName(userRequest.getLastName());
//			            user.setType(userRequest.getType());
			            user.setEmail(userRequest.getEmail());
			            user.setPassword(userRequest.getPassword());
//			            user.setCompany(userRequest.getCompany());
			            user.setDeleted(userRequest.isDeleted());
//			            user.setUserName(userRequest.getUserName());
//			            user.setRole(userRequest.getRole());
			            user.setVerificationEnabled(userRequest.isVerificationEnabled());
			            return user;
			        })
			        .collect(Collectors.toList());
	}

}
