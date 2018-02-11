package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
 
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	public Map<String,Object> userLogin(@RequestParam("userName") String userName,@RequestParam("password") String  password){ {
		
	  Map<String,Object> response =new HashMap<>();
	  UserDetails userDetails= loginService.getUserDetails(userName, password);
	  if(userDetails==null){
		  response.put("reponseCode", "401");
	     response.put("description", "User not found");
	  }else{
		 response.put("reponseCode", "200");
		  response.put("description", "success");
		  response.put("userDetails", userDetails);
	}
		return response;
	}
}
}
