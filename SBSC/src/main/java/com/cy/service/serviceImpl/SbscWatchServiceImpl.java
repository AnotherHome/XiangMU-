package com.cy.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.pojo.SbscWatch;
import com.cy.dao.SbscWatchDao;
import com.cy.service.service.SbscWatchService;
@Service
public class SbscWatchServiceImpl implements SbscWatchService{
	@Autowired
	private SbscWatchDao sbscWatchDao;
	@Override
	public List<SbscWatch> findSexObject(String watchSex) {
		List<SbscWatch> list = sbscWatchDao.findSexObject(watchSex);
		return list;
	}
	@Override
	public List<SbscWatch> findSexObjectLevel(Integer watchLevelId, String watchSex) {
		List<SbscWatch> list = sbscWatchDao.findSexObjectLevel(watchLevelId, watchSex);
		System.out.println(list);
		return list;
	}

}
