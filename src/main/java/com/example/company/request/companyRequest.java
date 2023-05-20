package com.example.company.request;

import java.util.List;

import com.example.company.entity.UserRole;
import com.example.company.entity.Users;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class companyRequest {
   
	private Long companyId;
    private String companyName;
    private String phoneNumber;
    private String emailId;
    private Boolean isDeleted;
    private String address;
    private List<Users> users;
    private List<UserRole> role;

	
}
