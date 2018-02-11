package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {
	
@RequestMapping(value="/connect/token")
public String getToken(@RequestParam("grant_type") String grantType,
		                @RequestParam("client_id") String client_id,
		                @RequestParam("client_secret") String client_secret,
		                @RequestParam("username") String username,
		                @RequestParam("password") String password) {
	
      String content= getFileContentData("token.json");
	
	return content;
	
}




@RequestMapping(value="calendar/GetEvents")
public String getCalenderEvents(@RequestBody Map<String,String>dataMap) {
	
	
	if(dataMap!=null)
	for (Entry<String, String> entry : dataMap.entrySet()) {
		System.out.println("key"+entry.getKey());
		System.out.println("data"+entry.getValue());
		
	}
	
      String content= getFileContentData("calender_events.json");
	
	return content;
	
}


@RequestMapping(value="/Hello")
public String getToken() {
	
      String content= getFileContentData("token.json");
	
	return content;
	
}

public String getFileContentData(String fileName) {
	String content = "";
	ClassPathResource cpr = new ClassPathResource(fileName);
	
	try {
	    InputStream in=cpr.getInputStream();
		byte[] bdata = FileCopyUtils.copyToByteArray(in);
	    content = new String(bdata, StandardCharsets.UTF_8);
	    in.close();
	    
	    return content;

	
	} catch (IOException e) {
   }
	
	return null;
}
}
