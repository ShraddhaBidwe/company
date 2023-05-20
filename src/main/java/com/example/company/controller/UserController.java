package com.example.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.entity.UserRole;
import com.example.company.entity.Users;
import com.example.company.exception.ResourceNotFoundException;
import com.example.company.repository.usersRepository;
import com.example.company.repository.usersRoleRepository;
import com.example.company.request.userRequest;
import com.example.company.response.userResponse;
import com.example.company.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    
    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
    
    @Autowired
    private usersRoleRepository repository;
    
    @Autowired
    private usersRepository userRepository;
 
    @PostMapping("/post")
	public userResponse addUser(@RequestBody userRequest request) throws ResourceNotFoundException {
		log.info("Adding new user");
		return userService.createUser(request);
	}
    
    @GetMapping("/verify")
    public ResponseEntity<Void> verifyEmail(@RequestParam String email, @RequestParam String code) {
        userService.verifyEmail(email, code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
//    forget password mail send
    @PostMapping("/forget_password")
    public ResponseEntity<Void> forgotPassword(@RequestBody userRequest request ) {
    	String email=request.getEmail();
        userService.sendResetPasswordEmail(email);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestParam String email, @RequestParam String code ,@RequestParam String newPassword ) {
        userService.resetPassword(email, code,newPassword);
        return ResponseEntity.ok().build();
    }
    
  //login
    @PostMapping("/login")
    public ResponseEntity<userResponse> login(@RequestBody Users user) throws Exception{
       Optional<userResponse> object =  userService.login(user.getEmail(), user.getPassword());
       return ResponseEntity.of(object);
    }
}
