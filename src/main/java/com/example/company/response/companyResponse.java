package com.example.company.response;

import java.util.List;

import com.example.company.entity.UserRole;
import com.example.company.entity.Users;
import com.example.company.request.companyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class companyResponse {

	private Long companyId;
    private String companyName;
    private String phoneNumber;
    private String emailId;
    private Boolean isDeleted;
    private String address;
    private List<Users> users;
    private List<UserRole> role;
    
//	public void setRole(List<UserRole> role) {
//		// TODO Auto-generated method stub
//		
//	}
}
