package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	CountryService countryService ;
	

	@Test
	public void contextLoads() {
	}
	

	@Test
	public void testcountries() {
	long count	=countryRepository.findAll().spliterator().getExactSizeIfKnown();
	
	assertEquals(253, count);
	}
	
	
	@Test
	public void testcountries1() {
		int count=countryService.getCountries(0, 1, "s").size();
	
	assertEquals(count,count);
	}

}
