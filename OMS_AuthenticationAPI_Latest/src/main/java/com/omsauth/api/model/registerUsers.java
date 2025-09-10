package com.omsauth.api.model;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;


public class registerUsers {

	@NotNull
	private String userName;
	private String password;
	private String lastLoginTime;
	private String accountCreationTime;
	private String isActive;
	private String passwordChangedTime;
	private String mobileNumber;
	private String accountLocked;
	private String role;
	private String refreshToken;
	
	 	private String firstName;
	    private String lastName;
	    private String phoneNumber;
	    private String address;
	    private String dob;
	    private String ssnType;
	    private String ssn;
	    private Integer age;
	    private String gender;
	    private String country;
	    private String state;
	    private String zipCode;
	    private String dpUrl;
		public registerUsers() {
			
		}
		public registerUsers(String userName, String password, String lastLoginTime, String accountCreationTime,
				String isActive, String passwordChangedTime, String mobileNumber, String accountLocked, String role,
				String refreshToken, String firstName, String lastName, String phoneNumber, String address, String dob,
				String ssnType, String ssn, Integer age, String gender, String country, String state, String zipCode,
				String dpUrl) {
			super();
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
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.dob = dob;
			this.ssnType = ssnType;
			this.ssn = ssn;
			this.age = age;
			this.gender = gender;
			this.country = country;
			this.state = state;
			this.zipCode = zipCode;
			this.dpUrl = dpUrl;
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
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getSsnType() {
			return ssnType;
		}
		public void setSsnType(String ssnType) {
			this.ssnType = ssnType;
		}
		public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		public String getDpUrl() {
			return dpUrl;
		}
		public void setDpUrl(String dpUrl) {
			this.dpUrl = dpUrl;
		}
		@Override
		public String toString() {
			return "registerUser [userName=" + userName + ", password=" + password + ", lastLoginTime=" + lastLoginTime
					+ ", accountCreationTime=" + accountCreationTime + ", isActive=" + isActive
					+ ", passwordChangedTime=" + passwordChangedTime + ", mobileNumber=" + mobileNumber
					+ ", accountLocked=" + accountLocked + ", role=" + role + ", refreshToken=" + refreshToken
					+ ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
					+ ", address=" + address + ", dob=" + dob + ", ssnType=" + ssnType + ", ssn=" + ssn + ", age=" + age
					+ ", gender=" + gender + ", country=" + country + ", state=" + state + ", zipCode=" + zipCode
					+ ", dpUrl=" + dpUrl + "]";
		}
		public void setUserDetails(userDetailsDTO newUserdetails) {
			// TODO Auto-generated method stub
			
			
		}
	    
}
