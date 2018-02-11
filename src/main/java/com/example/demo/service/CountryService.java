package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CountryEntity;
import com.example.demo.entity.QCountryEntity;
import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	EntityManager em;
	
	public List<Country> getCountries(int pageId,int size, String searchText){
		Pageable pageable=new PageRequest(pageId, size);
		ModelMapper modelMapper=new ModelMapper();
		
		Expression<String>expression=Expressions.asString(searchText);
		QCountryEntity countryEntity=QCountryEntity.countryEntity;
		BooleanExpression be=QCountryEntity.countryEntity.name.like("%"+searchText+"%").or(countryEntity.nicename.like("%"+searchText+"%"));
		
		JPAQuery<CountryEntity> query=new JPAQuery<>(em);
		List<CountryEntity>country1= query.from(QCountryEntity.countryEntity).where(be).limit(10).fetch();
		
		List<Country>countries=new ArrayList<>();
		
		//be.
		Iterable<CountryEntity> countryEntities=countryRepository.findAll(be,pageable);
		countryEntities.iterator().forEachRemaining(countryEntity1->{
		Country country=modelMapper.map(countryEntity1, Country.class);
		countries.add(country);
		});
		
		/*for (CountryEntity countryEntity1 : countryEntities) {
			Country country=modelMapper.map(countryEntity1, Country.class);
			countries.add(country);
		}*/
		
	return countries;
	}
	
	

}
