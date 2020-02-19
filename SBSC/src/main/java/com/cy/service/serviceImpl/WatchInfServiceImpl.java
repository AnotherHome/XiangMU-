package com.cy.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.dto.PageObject;
import com.cy.common.pojo.WatchInf;
import com.cy.dao.WatchInfDao;
import com.cy.service.service.WatchInfService;



@Service 
public class WatchInfServiceImpl implements WatchInfService {
	@Autowired 
	private WatchInfDao dao;
	
	
	@Override
	public List<WatchInf> findWatchs() {
		/** 查询所有记录 */
		return dao.findWatchs();
		
	}

	@Override
	public WatchInf findWatchById(Integer id) {
		/** 根据id查询记录 */
//		WatchInf inf = watchInfService.findWatchById(id);
		return dao.findWatchById(id);
	}

	@Override
	public PageObject<WatchInf> findPageObjects(String watchName,Integer pageCurrent) {
		
		if(pageCurrent==null||pageCurrent<=0) pageCurrent=1;
		
		/** 分页查询 */
		String name = watchName;
		int pageSize = 9;
		/**	计算总记录数,如果pageCurrent+pageSize大于总记录数,pageSize=总记录数 **/
		int startIndex = (pageCurrent-1)*pageSize;
		int rows = dao.getRowCount(name);
		
		
		//System.out.println("从第"+startIndex+"条记录开始,输出"+pageSize+"条记录");
		List<WatchInf> result = dao.findPageObjects(watchName, startIndex, pageSize);
		
		PageObject<WatchInf> pageObj = new PageObject<>(
				pageCurrent,pageSize, rows, result);
		return pageObj;
	}

}
