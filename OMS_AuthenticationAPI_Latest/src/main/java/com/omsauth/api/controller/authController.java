package com.omsauth.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omsauth.api.model.Users;
import com.omsauth.api.model.registerUsers;
import com.omsauth.api.model.userLoginDTO;
import com.omsauth.api.service.UserRegisterService;

@RestController
@RequestMapping("/auth")
public class authController {
	
	@Autowired
	UserRegisterService service;
	@PostMapping("/register")
	public void registerUser(@RequestBody registerUsers user)
	{
		service.regsiterUser(user);
		
	}

	@PostMapping("/login")
	public String loginUser(@RequestBody userLoginDTO user)
	{
		return service.verify(user);
		
	}
	@PostMapping("/reset-password/{userId}")
	public ResponseEntity<Users> resetPassword(@PathVariable Integer  userId,@RequestParam String newPassword)
	{
		return service.resetPassword(userId,newPassword);
		
	}

	

}
