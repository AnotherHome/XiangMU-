package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.dto.JsonResult;
import com.cy.service.service.WatchInfService;



//@Controller
@RestController
@RequestMapping("/watch/")
public class WatchController {
	@Autowired
	private WatchInfService watchInfService;
	
//	@ResponseBody
	@RequestMapping("findAll")
	public JsonResult findAll() {
		/** 查找所有记录 */
		Object findWatchs = watchInfService.findWatchs();
		return new JsonResult(findWatchs);
	}
	
	@RequestMapping("findPage")
	public JsonResult findPage(String watchName,Integer pageCurrent) {
		/** 分页记录 */
		Object findWatchs = watchInfService.findPageObjects(watchName,pageCurrent);
		return new JsonResult(findWatchs);
	}
	
	@RequestMapping("findById")
	public JsonResult findWatchById(int id) {
		/** 分页记录 */
		Object findWatchs = watchInfService.findWatchById(id);
		return new JsonResult(findWatchs);
	}
	
}
