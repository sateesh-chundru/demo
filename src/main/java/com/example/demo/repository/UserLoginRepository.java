package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserLoginEntity;

public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Long> {
	
	public UserLoginEntity findByUserNameAndPasswordOrEmailAndPassword(String username,String password,String email,String password1);

}
