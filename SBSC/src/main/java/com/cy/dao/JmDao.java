package com.cy.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cy.common.pojo.JmEntity;



@Mapper
public interface JmDao {

/****************************************************************************************************/
	/*寄卖添加数据层接口方法*/
	int insertjm(JmEntity entity);
	
	
/****************************************************************************************************/	
}
