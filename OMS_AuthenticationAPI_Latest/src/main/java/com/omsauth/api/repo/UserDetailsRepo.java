package com.omsauth.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omsauth.api.model.userDetailsDTO;

public interface UserDetailsRepo extends JpaRepository<userDetailsDTO,Integer> {

}
