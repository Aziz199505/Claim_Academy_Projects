package com.claim.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.CraiglistItem;

@Repository
public interface CraiglistItemRepository  extends JpaRepository<CraiglistItem,Long>{
	/*
	 * public Optional<CraiglistItem> findByPid(@Param("pid") String
	 * pid, @Param("prefId") long prefId);
	 */	
	@Query("SELECT u FROM CraiglistItem u WHERE u.pid = ?1 and u.prefId = ?2")
	Optional<CraiglistItem> findByPid(String pid, long prefId);
	
	public Optional<CraiglistItem> findByPrefId(@Param("prefId") long prefId);
	 
	 @Transactional
	 List<CraiglistItem> deleteCraigItemByPrefId(String prefId);
	
}
