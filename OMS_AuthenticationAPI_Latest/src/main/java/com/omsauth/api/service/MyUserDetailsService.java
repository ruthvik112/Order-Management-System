package com.omsauth.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.omsauth.api.model.Users;
import com.omsauth.api.repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepo userrepo;

	@Override
	public UserDetails loadUserByUsername(String UserName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user=userrepo.findByUserName(UserName);
		if(user==null)
		{
			throw new UsernameNotFoundException("User Not Found");
		}
		return new UserPrincipal(user);
	}
	

}
