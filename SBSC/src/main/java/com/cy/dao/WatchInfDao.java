package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.common.pojo.WatchInf;



@Mapper
public interface WatchInfDao {
	
	List<WatchInf> findWatchs();
	
	WatchInf findWatchById(int id);
	
	List<WatchInf> findPageObjects(
			@Param("watchName")String watchName,
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
	
	int getRowCount(@Param("watchName")String watchName);
		
	}
