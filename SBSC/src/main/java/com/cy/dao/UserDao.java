package com.cy.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cy.common.pojo.UserEntity;
@Mapper
public interface UserDao {
	
	UserEntity findUserByUserName(String username);
	
}
