package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	@Query("SELECT u FROM Users u WHERE u.username = :username")
	Users getUserByName(String username);
	
	@Query("Select u from Users u where u.email=:email")
	Users findUserByEmail(@Param("email") String email);

	@Query("Select u from Users u where u.email=:email And u.password=:password")
	Users findByEmailIdAndPassword(@Param("email")String email ,@Param("password")String password);
	
}
