package com.omsauth.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class userDetailsDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userDetailsId;

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
    
    
	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@JsonIgnore
    private Users user;
    


	public userDetailsDTO() {
	
	}

	public userDetailsDTO(Integer userDetailsId, String firstName, String lastName, String phoneNumber, String address,
			String dob, String ssnType, String ssn, Integer age, String gender, String country, String state,
			String zipCode, String dpUrl, Users user) {
		super();
		this.userDetailsId = userDetailsId;
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
		this.user = user;
	}

	public Integer getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(Integer userDetailsId) {
		this.userDetailsId = userDetailsId;
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
	



	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}


    
	

}
