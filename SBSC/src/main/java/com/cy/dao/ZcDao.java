package com.cy.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cy.common.pojo.ZcEntity;



@Mapper
public interface ZcDao {

	int inObject(ZcEntity Zentity);
	
	
	
	
}
