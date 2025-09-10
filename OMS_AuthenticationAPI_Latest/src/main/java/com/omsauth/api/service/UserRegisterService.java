package com.omsauth.api.service;

import org.springframework.security.core.Authentication;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.omsauth.api.exceptions.userNotFoundException;
import com.omsauth.api.model.Users;
import com.omsauth.api.model.registerUsers;
import com.omsauth.api.model.userDetailsDTO;
import com.omsauth.api.model.userLoginDTO;
import com.omsauth.api.repo.UserRepo;

@Service
public class UserRegisterService {
 
	@Autowired
	UserRepo repo;
	@Autowired
	AuthenticationManager auth;
	@Autowired
	JwtService jwtservice;
	@Value("${spring.datasource.username}")
	String dbUname;
	public void regsiterUser(registerUsers user) {
		// TODO Auto-generated method stub	
		 Users newUser=new Users();
		 BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
		 newUser.setUserName(user.getUserName());
		 newUser.setPassword(encoder.encode(user.getPassword()));
		 newUser.setLastLoginTime(user.getLastLoginTime());
		 newUser.setAccountCreationTime(user.getAccountCreationTime());
		 newUser.setIsActive(user.getIsActive());
		 newUser.setPasswordChangedTime(user.getPasswordChangedTime());
		 newUser.setMobileNumber(user.getMobileNumber());
		 newUser.setAccountLocked(user.getAccountLocked());
		 newUser.setRole(user.getRole());
		 newUser.setRefreshToken(user.getRefreshToken());
		 

	        // Create UserDetails
	        userDetailsDTO newUserdetails = new userDetailsDTO();
	        newUserdetails.setFirstName(user.getFirstName());
	        newUserdetails.setLastName(user.getLastName());
	        newUserdetails.setAddress(user.getAddress());
	        newUserdetails.setAge(user.getAge());
	        newUserdetails.setCountry(user.getCountry());
	        newUserdetails.setDob(user.getDob());
	        newUserdetails.setDpUrl(user.getDpUrl());
	        newUserdetails.setGender(user.getGender());
	        newUserdetails.setSsn(user.getSsn());
	        newUserdetails.setSsnType(user.getSsnType());
	        newUserdetails.setState(user.getState());
	        newUserdetails.setZipCode(user.getZipCode());

	        newUserdetails.setUser(newUser);
	        newUser.setUserDetailsDTO(newUserdetails);

	        // Save user (cascade will save details)
	     /*   userRepository.save(user);*/
		
		//BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
		//user.setPassword(encoder.encode(user.getPassword()));
		repo.save(newUser);
	}
	public String verify(userLoginDTO user) {
		// TODO Auto-generated method stub
		
		Authentication authentication=auth.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
		if(authentication.isAuthenticated())
		{
			//return "Success";
			return jwtservice.generateToken(user.getUserName());
		}
		return "Fail";
	}
	public Users fetchUserDetails(Integer userId)  {
		System.out.println("----------------dbUname--------------"+dbUname);
		Users u= repo.findById(userId).orElseThrow(()->new userNotFoundException("User Not Found"));
		if(u.getRole()==null)
		{
			throw new NullPointerException("Role Not Found");
		}
		return u;
	}
	public ResponseEntity<Users> resetPassword(Integer userId, String newPassword) {
		Users user=repo.findById(userId).orElseThrow(()->new userNotFoundException("User not found. Cannot reset password"));
		if(user!=null)
		{
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
			user.setPassword(encoder.encode(newPassword));
			return ResponseEntity.ok(repo.save(user));
		}
		return ResponseEntity.notFound().build();
		
	}
	public ResponseEntity<String> deleteAccount(Integer userId) {
		Users user=repo.findById(userId).orElseThrow(()->new userNotFoundException("User not found. Cannot Delete Account"));
       if(user!=null)
       {
    	   repo.deleteById(userId);
       }
       if (!repo.existsById(userId)) {
    	    return ResponseEntity.ok("Deleted successfully");
    	}
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete failed");

	}
	public ResponseEntity<Users> updateUser(registerUsers user,Integer userId) {
		Users dbUser=repo.findById(userId).orElseThrow(()->new userNotFoundException("User not found to Update"));

		if(dbUser!=null)
		{
			 dbUser.setUserName(user.getUserName());
			 dbUser.setLastLoginTime(user.getLastLoginTime());
			 dbUser.setAccountCreationTime(user.getAccountCreationTime());
			 dbUser.setIsActive(user.getIsActive());
			 dbUser.setPasswordChangedTime(user.getPasswordChangedTime());
			 dbUser.setMobileNumber(user.getMobileNumber());
			 dbUser.setAccountLocked(user.getAccountLocked());
			 dbUser.setRole(user.getRole());
			 dbUser.setRefreshToken(user.getRefreshToken());
			 

			 userDetailsDTO dbDetails = dbUser.getUserDetailsDTO();
			    if (dbDetails == null) {
			        dbDetails = new userDetailsDTO();
			        dbDetails.setUser(dbUser); // set relationship
			        dbUser.setUserDetailsDTO(dbDetails);
			    }

			    dbDetails.setFirstName(user.getFirstName());
			    dbDetails.setLastName(user.getLastName());
			    dbDetails.setAddress(user.getAddress());
			    dbDetails.setAge(user.getAge());
			    dbDetails.setCountry(user.getCountry());
			    dbDetails.setDob(user.getDob());
			    dbDetails.setDpUrl(user.getDpUrl());
			    dbDetails.setGender(user.getGender());
			    dbDetails.setSsn(user.getSsn());
			    dbDetails.setSsnType(user.getSsnType());
			    dbDetails.setState(user.getState());
			    dbDetails.setZipCode(user.getZipCode());

			    // 🔹 Save (cascade = true ensures UserDetailsDTO is also saved)
			    Users updatedUser = repo.save(dbUser);

			    return ResponseEntity.ok(updatedUser);
		}
		return ResponseEntity.notFound().build();
	}
	
}
