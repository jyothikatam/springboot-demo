package com.primecore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.primecore.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "select * from user where user_id=:userId", nativeQuery = true)
	User getById(@Param("userId") Long userId);

}
