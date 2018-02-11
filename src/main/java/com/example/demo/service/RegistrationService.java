package com.example.demo.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RegistrationEntity;
import com.example.demo.entity.UserLoginEntity;
import com.example.demo.model.Registration;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.UserLoginRepository;

@Service
public class RegistrationService {
	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Transactional
	public void saveRegistration(Registration registration) {
		ModelMapper modelMapper=new ModelMapper();
		RegistrationEntity registrationEntity=	modelMapper.map(registration, RegistrationEntity.class);
		registrationRepository.save(registrationEntity);
		registration.setRegistrationId(registrationEntity.getRegistrationId());
		UserLoginEntity userLoginEntity=new UserLoginEntity();
		userLoginEntity.setUserName(registrationEntity.getUserName());
		userLoginEntity.setEmail(registrationEntity.getEmail());
		userLoginEntity.setPassword(registrationEntity.getPassword());
		userLoginEntity.setCreatedDate(new Date());
		userLoginEntity.setMoidifiedDate(new Date());
		userLoginEntity.setRegistration(registrationEntity);
		userLoginRepository.save(userLoginEntity);
		
	}
	
	
	
	

}
