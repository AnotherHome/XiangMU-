package com.cy.service.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cy.common.dto.PageObject;
import com.cy.common.pojo.WatchInf;



public interface WatchInfService {
	
	/** 查找所有记录,每条记录封装到一个pojo中,多条记录(pojo)要用map或者list存储 */
	List<WatchInf> findWatchs();
	
	/** 根据id查找单条记录 */
	WatchInf findWatchById(Integer id);
	
	/** 分页查询 */
	PageObject<WatchInf> findPageObjects(
			@Param("watchName")String watchName,
			@Param("currentPage")Integer pageCurrent);
	/** xxxx */
}
