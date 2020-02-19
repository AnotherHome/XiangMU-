package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.common.dto.JsonResult;
import com.cy.common.pojo.JmEntity;
import com.cy.service.service.JmService;



@ResponseBody
@Controller
@RequestMapping("/jm/")
public class JmController {

	
	@Autowired
	private JmService jmService;
	
	@RequestMapping("doInsertSavejm")
	public JsonResult doInsertSavejm(JmEntity entity) {
		
		jmService.insertSavejm(entity);
		
		return new JsonResult("添加成功");
	}
	
}
