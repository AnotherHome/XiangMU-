package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.common.pojo.Watch;



@Mapper
public interface SysFemaleWatchDao {
	
	//@Select("select count(*) from watch where watch_sex=\"women\" ")
	List<Watch> findWatchesByName(
			@Param(value="watchName") String watchName,
			@Param(value = "start") int start, 
			@Param(value = "num") int num);
			    
//	@Select("select * from watch "
//			+ "where watch_sex=\"women\"")
	List<Watch> findWatches(
			@Param(value = "start") int start, 
			@Param(value = "num") int num);
	
	@Select("select count(*) from watch where watch_sex=\"women\" ")
	Integer getCount();
}
