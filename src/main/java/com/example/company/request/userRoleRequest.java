package com.example.company.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userRoleRequest {

	private Long RoleId;
	private String userRole;
	private Long companyId;
}
