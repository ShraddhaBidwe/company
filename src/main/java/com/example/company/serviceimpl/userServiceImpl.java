package com.example.company.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.company.repository.usersRepository;
import com.example.company.service.UserService;
import com.example.company.transformer.userResponseConverter;
import com.example.company.entity.Users;
import com.example.company.exception.ResourceNotFoundException;
import com.example.company.request.userRequest;
import com.example.company.request_transform.UserRequestConverter;
import com.example.company.responce_transform.UserResponseConverter;
import com.example.company.response.userResponse;


@Service
public class userServiceImpl implements UserService{
	
	@Autowired
	private usersRepository repository;

	 @Autowired
	    private JavaMailSender mailSender;
	 
	 @Autowired
		BCryptPasswordEncoder passwordEncoder;
	 
	// Store the verification codes in a map
 private HashMap<String, String> verificationCodes = new HashMap<>();
 private HashMap<String, String> resetPasswordCodes = new HashMap<>();
	@Override
	public userResponse createUser(userRequest request) throws ResourceNotFoundException {
//		if (userRequest.getCompany() != null && !userRequest.getCompany().getIsDeleted()) {
//			Company company = companyRepository.findById(userRequest.getCompany().getCompanyId()).orElseThrow(
//					() -> new ResourceNotFoundException("Company", "id", userRequest.getCompany().getCompanyId()));

			Users user = UserRequestConverter.toEntity(request);
//			user.setCompany(company);

			Users savedUser = repository.save(user);
			System.out.println("data saved");
			System.out.println("going to email meth");
			  sendVerificationEmail(user);
			  return UserResponseConverter.convertToResponse(savedUser);

	}
	
	

    @Override
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Users getUserById(Long userId) {
        Optional<Users> user = repository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public Users saveUser(Users user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
    	repository.deleteById(userId);
    }

	 private void sendVerificationEmail(Users user) {
	        // Generate a random verification code
		 String verificationCode = UUID.randomUUID().toString().substring(0, 4);
			System.out.println("token genrated : "+verificationCode);
			
	        // Store the verification code in the map
	        verificationCodes.put(user.getEmail(), verificationCode);
	        System.out.println("saved in hash set"+verificationCodes);
	        // Send the verification email
	        String subject = "Verify your email address";
	        String message = "Please click on the following link to verify your email address: "
	            + "http://localhost:8082/users/verify?email=" + user.getEmail() + "&code=" + verificationCode;
	        System.out.println("mail genrated");
	        sendEmail(user.getEmail(), subject, message);
	    }
	 
	 private void sendEmail(String email, String subject, String body) {
		 System.out.print("send email called ");
	        SimpleMailMessage message = new SimpleMailMessage();
			 System.out.println("send with my mail id called ");
	        message.setFrom("pranumore1234@gmail.com");
	        System.out.println("send with my mail id called "+email);
	        message.setTo(email);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	        System.out.println("mail successfully send");
	    }
	 
	 @Override
	  public ResponseEntity<String> verifyEmail(String email, String code) {
	        // Get the verification code from the map
		 System.out.println("email : "+email+" verificationCode : "+code);
	        
	        if (verificationCodes.get(email).equals(code)) {
	            // Update the isEnable field to true
	        	System.out.println("verification code checked");
	            Users user = repository.findByEmail(email);
	            System.out.println("verification enable");
	            user.setVerificationEnabled(true);
	            
	            repository.save(user);
	            // Remove the verification code from the map
	            verificationCodes.remove(email);
	            System.out.println("verification sucessfull");
	            return ResponseEntity.ok().body("successfully verified");
	        } else {
	        	return ResponseEntity.badRequest().body("Error :couldent verify email");
	        }
	    }
	 @Override
		public void sendResetPasswordEmail(String email) {
			 String resetCode = UUID.randomUUID().toString().substring(0, 4);
			 Users user = repository.findByEmail(email);
			 resetPasswordCodes.put(user.getEmail(), resetCode);
			 String subject = "Reset your Password";
		     String message = "Please click on the following link to reset your password: "
		            + "http://localhost:8082/users/reset-password?email="+user.getEmail() +"&code=" + resetCode+ "&newPassword=";
		     System.out.println("mail genrated");
		        sendEmail(user.getEmail(), subject, message);
	 }

	 @Override
		public void resetPassword(String email , String code,String newPassword) {
			 String storedResetToken = resetPasswordCodes.get(email);
	            System.out.println("going to the resetpass link");
		        // Check if the user was found and the token is valid
			 if (storedResetToken != null && storedResetToken.equals(code)) {
			        // Reset the password for the user
				    System.out.println("email found");
			        Users user = repository.findByEmail(email);
			        System.out.println("setting new password");
			        user.setPassword(newPassword);
			        repository.save(user);
			        System.out.println("save data in repo");
			        // Remove the reset token from the Map
			        resetPasswordCodes.remove(email);
			    } else {
			        throw new RuntimeException("Invalid reset token.");
			    }
		}
		
		
		public userServiceImpl(usersRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
	        this.repository = userRepository;
	        this.passwordEncoder = bCryptPasswordEncoder;
	    }
		
		public Optional<userResponse> login(String email, String password) throws Exception {
			try {
				Users userOptional = repository.findByEmail(email);
				if(!userOptional.isEmpty()) {
					if (passwordEncoder.matches(password, userOptional.get().getPassword()))
					{
//						System.out.printf(password,userOptional.get().getPassword());
						if (password.length() < 5) {
		                    throw new Exception("Password is too short");
		                }
						userResponse userResponse = userResponseConverter.convertToResponse(userOptional.get());
						return Optional.of(userResponse);
					}
					else {
						throw new Exception("Password not matches");
					}
				}else {
					throw new Exception(" User not found");
				}
			} catch (Exception e) {
				// Handle exception
				throw new Exception( e.getMessage());
			}
		}
}
