package com.cy.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.exception.ServiceException;
import com.cy.common.pojo.ZcEntity;
import com.cy.dao.ZcDao;
import com.cy.service.service.ZcService;


@Service
public class ZcServiceImpl implements ZcService {
/**寄卖Service实现类*/
	@Autowired
	private ZcDao ZcDao;

	@Override
	public void insertObject(ZcEntity Zentity) {
		if(Zentity==null)
			throw new ServiceException("数据不能为空");
			if(StringUtils.isEmpty(Zentity.getPassword()))
				throw new ServiceException("数据不能为空");
		
			ZcDao.inObject(Zentity);	
			
	}

}
