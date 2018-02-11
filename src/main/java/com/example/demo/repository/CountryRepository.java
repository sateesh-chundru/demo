package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.CountryEntity;

public interface CountryRepository extends PagingAndSortingRepository<CountryEntity, Integer> ,QueryDslPredicateExecutor<CountryEntity> {

	
}
