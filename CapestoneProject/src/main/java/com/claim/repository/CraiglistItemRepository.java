package com.claim.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.claim.entity.CraiglistItem;

public interface CraiglistItemRepository  extends JpaRepository<CraiglistItem,Long>{
	public Optional<CraiglistItem> findByPid(@Param("pid") String pid);
	
	public Optional<CraiglistItem> findByPrefId(@Param("prefId") long pid);
	 
	 @Transactional
	 List<CraiglistItem> deleteCraigItemByPrefId(String prefId);
	
}
