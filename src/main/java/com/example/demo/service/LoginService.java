package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserLoginEntity;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserLoginRepository;

@Service
public class LoginService {
	@Autowired
	UserLoginRepository userLoginRepository;
	
	public UserDetails getUserDetails(String userName,String password){
		
		UserLoginEntity userLoginEntity= userLoginRepository.findByUserNameAndPasswordOrEmailAndPassword(userName, password, userName, password);
		if(userLoginEntity==null){
			return null;
		}
		UserDetails userDetails=new UserDetails();
		userDetails.setEmail(userLoginEntity.getEmail());
		userDetails.setFirstName(userLoginEntity.getRegistration().getFirstName());
		userDetails.setLastName(userLoginEntity.getRegistration().getLastName());
		userDetails.setPhoneNumber(userLoginEntity.getRegistration().getPhoneNumber());
		userDetails.setUserName(userLoginEntity.getUserName());
		return userDetails;
	}

}
