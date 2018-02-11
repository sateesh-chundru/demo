package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User_Logins")
public class UserLoginEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long loginId;
	private String email;
	private String password;
	private String userName;
	private Date createdDate;
	private Date moidifiedDate;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="registration_id")
	RegistrationEntity registration;
	
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getMoidifiedDate() {
		return moidifiedDate;
	}
	public void setMoidifiedDate(Date moidifiedDate) {
		this.moidifiedDate = moidifiedDate;
	}
	public RegistrationEntity getRegistration() {
		return registration;
	}
	public void setRegistration(RegistrationEntity registration) {
		this.registration = registration;
	}
	
	
	
	
	
	
	
	

}
