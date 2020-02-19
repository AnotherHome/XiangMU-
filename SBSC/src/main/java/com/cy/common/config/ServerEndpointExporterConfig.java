package com.cy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@Configuration
public class ServerEndpointExporterConfig {
	
	/**
     * 
    * @Title: serverEndpointExporter  
    * @Description: 检测服务类实现
    * @return ServerEndpointExporter 
    * @throws
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
        return new ServerEndpointExporter();
    }

}
