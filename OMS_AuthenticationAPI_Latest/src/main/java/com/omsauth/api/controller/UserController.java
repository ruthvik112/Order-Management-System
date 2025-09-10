package com.omsauth.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.omsauth.api.model.*;
import com.omsauth.api.service.*;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserRegisterService service;
	
	@GetMapping("/me/{userId}")
	public Users fetchUserDetails(@PathVariable Integer userId)
	{
		return service.fetchUserDetails(userId);
		
	}
	@DeleteMapping("/delete/{userId}")
	
	public ResponseEntity<String> deleteAccount(@PathVariable Integer  userId)
	{
		return service.deleteAccount(userId);
		
	}
	@PutMapping("/update/{userID}")
	public ResponseEntity<Users> updateUser(@RequestBody  @Validated registerUsers user,@PathVariable Integer userID)
	{
		return service.updateUser(user,userID);
	}

}
