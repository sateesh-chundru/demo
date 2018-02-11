package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;

@RestController
public class RegistrationController {
	
	
	@Autowired
	RegistrationService registrationService;																

	@RequestMapping(value="/registration/save",method=RequestMethod.POST)
	public Registration SaveRegistration(@RequestBody Registration registration) {
		registration.setCreatedTime(new Date());
		registration.setModifiedTime(new Date());
		
		registrationService.saveRegistration(registration);
		
		return registration;
	}
	
}
