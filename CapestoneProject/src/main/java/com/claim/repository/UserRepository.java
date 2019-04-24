package com.claim.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
	 public Optional<User> findByEmail(@Param("email") String email);
}
