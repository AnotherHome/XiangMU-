package com.cy.service.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnError;


import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


import org.springframework.web.socket.server.standard.SpringConfigurator;

@ServerEndpoint(value="/{role}/{userId}")
@Component
@Slf4j
public class Customer {

	//当前连接进来的客户
	public static Map<String, Session> customerSessionMap = new ConcurrentHashMap<String, Session>();

	//调度内所有的客服
	public static Map<String, Session> serviceSessionMap = new ConcurrentHashMap<String, Session>();

	//没任务的客服
	public static CopyOnWriteArraySet<String> activeServiceSet = new CopyOnWriteArraySet<String>();

	//已建立连接的客户与客服
	//customer ----  service
	public static Map<String,String> csmap = new ConcurrentHashMap<String, String>();
	
	//service ----  customer
	public static Map<String,String> scmap = new ConcurrentHashMap<String, String>();

	//建立连接要显示有几个客服
	@OnOpen
	public void onOpen(@PathParam("role") String role,@PathParam("userId") String userId,Session session) {
		log.info("WebSocketService onOpen: "+role + userId);

		if(role.equals("service")) {
			//一开始都是活跃的
			activeServiceSet.add(userId);
			serviceSessionMap.put(userId, session);
		}
		
		if(role.equals("customer")) {
			//锁什么比较好啊？
			//synchronized (Customer.class) {		
				customerSessionMap.put(userId, session);
				int allServiceSize = serviceSessionMap.size();
				int activeServiceSize = activeServiceSet.size();
				if(allServiceSize == 0) {
					//回传给他,这里为什么object，我还不懂
					session.getAsyncRemote().sendObject(-1);
				}else { //如果还有客服上班
					
					if(activeServiceSize == 0) {
						session.getAsyncRemote().sendObject(0);
						return;
					}
					
					
					for(String serviceKey : activeServiceSet) {
						//随意移除一个就行，并维护关系表
						activeServiceSet.remove(serviceKey);
						csmap.put(userId, serviceKey);
						scmap.put(serviceKey, userId);
						session.getAsyncRemote().sendObject(activeServiceSize);	
						break;
					}
														
				}
				
		}

	}



	//收到消息然后进行调度 
	@OnMessage
	public void OnMessage(@PathParam("role") String role,@PathParam("userId") String userId,Session session,String message) {

		log.info("WebSocketService OnMessage: "+message);

		if(role.equals("customer")) {
//			for(Session session_ : serviceSessionMap.values()) {
//				session_.getAsyncRemote().sendText(message);
//			}
			
			String serviceName = csmap.get(userId);
			//不应该没有的吧?
			if(serviceName!=null) {
				//点对点了
				Session sessionForYou = serviceSessionMap.get(serviceName);	
				sessionForYou.getAsyncRemote().sendText(message);
			}else {//如果确实没有，应该是分配的时候出错了
				System.out.println("---------分配的时候出错了---------------");
				session.getAsyncRemote().sendObject(-1);
			}
			
		}


		if(role.equals("service")) {

//			for(Session session_ : customerSessionMap.values()) {
//				session_.getAsyncRemote().sendText(message);
//			}
			String customerName = scmap.get(userId);
			Session session2 = customerSessionMap.get(customerName);
			session2.getAsyncRemote().sendText(message);
			
		}

	}

	
	@OnClose
	public void OnClose(@PathParam("role") String role,@PathParam("userId") String userId) {
		log.info("WebSocketService OnClose: "+role + userId);	
		if(role.equals("customer")) {
			String serviceName = csmap.get(userId);		
			customerSessionMap.remove(userId);
			
			csmap.remove(userId);
			
			if(serviceName!=null) {
				scmap.remove(serviceName);
				activeServiceSet.add(serviceName);
			}
		
		}		
		if(role.equals("service")) {
			String customerName = scmap.get(userId);
			serviceSessionMap.remove(userId);
			
			scmap.remove(userId);
			//有可能没有服务对象,没有参数传过来的
			if(customerName!=null) {
				csmap.remove(customerName);
			}			
			activeServiceSet.add(userId);									
		}		
	}

	
	@OnError
	public void error(@PathParam("role") String role,Session session, Throwable t) {
		log.info("WebSocketService error: "+session);	
		System.out.println("----"+role);
		t.printStackTrace();
	}
}
