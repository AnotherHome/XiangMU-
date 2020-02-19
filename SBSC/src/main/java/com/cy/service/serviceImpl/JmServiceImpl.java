package com.cy.service.serviceImpl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.exception.ServiceException;
import com.cy.common.pojo.JmEntity;
import com.cy.dao.JmDao;

import com.cy.service.service.JmService;



@Service
public class JmServiceImpl implements JmService {
/**寄卖实现类*/
	@Autowired
	private JmDao jmDao;
	@Override
	public void insertSavejm(JmEntity entity) {
		
		if(entity==null)
		throw new ServiceException("数据不能为空");
		if(StringUtils.isEmpty(entity.getJmText()))
			throw new ServiceException("某个不能为空");
		
		//获取到的图片路径
		String Img = entity.getJmImg();
		File originalFile = new File(Img);//指定要读取的图片
	
		//给图片路径重新赋值
		int pos = Img.lastIndexOf("\\");
		Img = Img.substring(pos+1, 27);
		entity.setJmImg(Img);
		jmDao.insertjm(entity);
//		//读取文件
//	        try {
//	            File result = new File("D:\\"+Img);//要写入的图片
//	            if (result.exists()) {//校验该文件是否已存在
//	                result.delete();//删除对应的文件，从磁盘中删除
//	                result = new File("D:\\"+Img);//只是创建了一个File对象，并没有在磁盘下创建文件
//	                
//	            }
//	            if (!result.exists()) {//如果文件不存在
//	                result.createNewFile();//会在磁盘下创建文件，但此时大小为0K
//	            }
//	            FileInputStream in = new FileInputStream(originalFile);
//	            FileOutputStream out = new FileOutputStream(result);// 指定要写入的图片
//	            int n = 0;// 每次读取的字节长度
//	            byte[] bb = new byte[1024];// 存储每次读取的内容
//	            while ((n = in.read(bb)) != -1) {
//	                out.write(bb, 0, n);// 将读取的内容，写入到输出流当中
//	            }
//	            //执行完以上后，磁盘下的该文件才完整，大小是实际大小
//	            out.close();// 关闭输入输出流
//	            in.close();
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	
//		
//		try {
//			
//			jmDao.insertjm(entity);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			throw new ServiceException();
//		}
		
	}

}
