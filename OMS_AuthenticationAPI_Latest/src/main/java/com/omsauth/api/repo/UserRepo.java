package com.omsauth.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.omsauth.api.model.Users;

public interface UserRepo extends JpaRepository<Users,Integer> {

	@Query("SELECT u FROM Users u WHERE u.userName = :UserName")
	Users findByUserName(@Param("UserName")String UserName);

}
