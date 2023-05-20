package com.example.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.company.entity.Users;
import com.example.company.exception.ResourceNotFoundException;
import com.example.company.repository.menuRepository;
import com.example.company.repository.roleMenuMappingRepository;
import com.example.company.repository.usersRepository;
import com.example.company.repository.usersRoleRepository;
import com.example.company.request.userRequest;
import com.example.company.response.userResponse;

@Service
public interface UserService {
	
	public List<Users> getAllUsers();
    public Users getUserById(Long userId);
    public Users saveUser(Users user);
    public void deleteUser(Long userId);
    userResponse createUser(userRequest userRequest) throws ResourceNotFoundException;
	 public ResponseEntity<String> verifyEmail(String email, String code);
	public void sendResetPasswordEmail(String email);
	Optional<userResponse> login(String email, String password) throws Exception;
	public void resetPassword(String email, String code,String newPassword);

}
