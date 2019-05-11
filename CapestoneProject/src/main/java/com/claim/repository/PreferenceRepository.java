package com.claim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference,Long>{
	
	// public Optional<User> findByEmail(@Param("email") String email);
	 public Optional<Preference> findByPrefId(@Param("prefId") long preference);

	

}
