package com.example.company.response;

import java.util.List;

import com.example.company.entity.UserRole;
import com.example.company.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userResponse {

	private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
	private boolean isDeleted;
	private UserRole role;
	private boolean verificationEnabled;
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//	    String usePassword = encoder.encode(password);
		this.password = password; 
	}
}
