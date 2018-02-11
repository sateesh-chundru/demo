package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;

@RestController
public class CountriesController {
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/countries/list",method=RequestMethod.GET)
	public List<Country>getCountries(@RequestParam("pageId") int pageId,@RequestParam("size") int size,@RequestParam("searchText")String searchText){
		
		return countryService.getCountries(pageId, size,searchText);
	}

}
