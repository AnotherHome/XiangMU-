package com.cy.boottest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootTest {

	@Autowired
	DataSource datasource;
	
	@Test
	public void contextLoads() throws SQLException {
		System.out.println(datasource);
		Connection connection = datasource.getConnection();
		System.out.println(connection);
		PreparedStatement prepareStatement = connection.prepareStatement("select * from test_goods");
		
		ResultSet rs = prepareStatement.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + "," +rs.getString(2) + ","+rs.getString(3)+","+rs.getString(4));
		}
		
	}
	
}
