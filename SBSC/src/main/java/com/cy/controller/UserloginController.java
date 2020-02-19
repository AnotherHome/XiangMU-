package com.cy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.dto.JsonResult;
import com.cy.common.exception.ServiceException;
import com.cy.common.pojo.UserEntity;
import com.cy.common.web.GlobalExceptionHandler;
import com.cy.dao.UserDao;


@Controller
@RequestMapping("/user/")
public class UserloginController {
	
	   @Autowired
	   private UserDao userDao;
	
	   @RequestMapping("doLogin")
	   @ResponseBody
	   public JsonResult doLogin(String username,String password){
		   
		   if(username==null || password==null) {
			   JsonResult jsonResult = new JsonResult("请输入再登录");
			   jsonResult.setState(2);
			   return jsonResult;
		   }
		   
		   //qu kong
		   UserEntity user = userDao.findUserByUserName(username);
		   String usernameDao = user.getUsername();
		   String passwordDao = user.getPassword();
		   if(username.equals(usernameDao) && password.equals(passwordDao) ) {
			   JsonResult jsonResult = new JsonResult("登陆成功");
			   jsonResult.setState(1);
			   return jsonResult;
		   }else {
			   //throw new ServiceException("账号密码错误");
			   
			   JsonResult jsonResult = new JsonResult("账号密码错误");
			   jsonResult.setState(0);
			   return jsonResult;
		   }
		   
		   
		   
	   }

}
