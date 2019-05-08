package com.claim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.User;
import com.claim.entity.WeekTime;




@Repository
public interface WeekTimeRepository extends JpaRepository<WeekTime,String>{
	
}