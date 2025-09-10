package com.omsauth.api.model;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotNull
	@Column(name = "user_name")
	private String userName;
	@JsonIgnore
	@NotNull
	@Column(name = "password")
	private String password;
	@Column(name = "last_login_time")
	private String lastLoginTime;
	@Column(name = "account_creation_time")
	private String accountCreationTime;
	@Column(name = "is_active")
	private String isActive;
	@Column(name = "password_changed_time")
	private String passwordChangedTime;
	@Column(name = "mobile_number", nullable = false)
	@NotNull
	private String mobileNumber;
	@Column(name = "account_locked")
	private String accountLocked;
	@Column(name = "role")
	private String role;
	@Column(name = "refresh_token")
	private String refreshToken;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private userDetailsDTO userDetailsDTO;
	public Users() {
	
	}
	public Users(Integer userId, String userName, String password, String lastLoginTime, String accountCreationTime,
			String isActive, String passwordChangedTime, String mobileNumber, String accountLocked, String role,
			String refreshToken) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.lastLoginTime = lastLoginTime;
		this.accountCreationTime = accountCreationTime;
		this.isActive = isActive;
		this.passwordChangedTime = passwordChangedTime;
		this.mobileNumber = mobileNumber;
		this.accountLocked = accountLocked;
		this.role = role;
		this.refreshToken = refreshToken;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getAccountCreationTime() {
		return accountCreationTime;
	}
	public void setAccountCreationTime(String accountCreationTime) {
		this.accountCreationTime = accountCreationTime;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getPasswordChangedTime() {
		return passwordChangedTime;
	}
	public void setPasswordChangedTime(String passwordChangedTime) {
		this.passwordChangedTime = passwordChangedTime;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(String accountLocked) {
		this.accountLocked = accountLocked;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public userDetailsDTO getUserDetailsDTO() {
		return userDetailsDTO;
	}
	public void setUserDetailsDTO(userDetailsDTO userDetailsDTO) {
		this.userDetailsDTO = userDetailsDTO;
	}
	

	
	

}
