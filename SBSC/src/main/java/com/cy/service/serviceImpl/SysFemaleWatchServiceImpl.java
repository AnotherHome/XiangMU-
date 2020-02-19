package com.cy.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.dto.PageObject2;
import com.cy.common.pojo.Watch;
import com.cy.dao.SysFemaleWatchDao;
import com.cy.service.service.SysFemaleWatchService;


@Service
public class SysFemaleWatchServiceImpl implements SysFemaleWatchService{
	
	@Autowired
	private SysFemaleWatchDao sysFemaleWatchDao;

	public PageObject2<Watch> findPageObjectByName(int curPage, String watchName){
		
		int pageSize = new PageObject2().getPageSize();
		int start = (curPage-1)*pageSize;
		int totalNum = sysFemaleWatchDao.getCount();
		int pageNum = (totalNum-1)/pageSize+1;
		List<Watch> watches = sysFemaleWatchDao.findWatchesByName(watchName, start, pageSize);
		return new PageObject2(watches, totalNum, pageNum, watches.size());
	}
	
	public PageObject2<Watch> findPageObject(int curPage){
		
		int pageSize = new PageObject2().getPageSize();
		int start = (curPage-1)*pageSize;
		int totalNum = sysFemaleWatchDao.getCount();
		int pageNum = (totalNum-1)/pageSize+1;
		List<Watch> watches = sysFemaleWatchDao.findWatches(start, pageSize);		
		return new PageObject2(watches, totalNum, pageNum, watches.size());
	}
	
}
