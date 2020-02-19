package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.common.pojo.SbscWatch;
@Mapper
public interface SbscWatchDao {
/**主页-------------------------------------------------------------*/
	//查男女 优惠固定
	List<SbscWatch> findSexObject(String watchSex);
	//查手表等级  性别
	List<SbscWatch> findSexObjectLevel(
			@Param("watchLevelId")Integer watchLevelId ,
			@Param("watchSex")String watchSex);
	
/**----------------------------------------------------------------*/	
/**男女分页*/


	
	
}
