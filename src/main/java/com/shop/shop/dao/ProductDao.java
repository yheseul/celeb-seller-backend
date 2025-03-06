package com.shop.shop.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.shop.shop.dto.Product;

@Component
public class ProductDao {
	
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;
	
	public List<Product> getAllProducts()throws Exception {
		Class.forName(DB_DRIVER);
		
		String sql="select * from product";
		
		try(
			Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PW);
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
				){
			
			List<Product> list=new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt("prodcode");
				String name = rs.getString("prodname");
				String imageUrl=rs.getString("pimg");
				int price=rs.getInt("price");
				long createdAt=rs.getLong("created_at");
				
				list.add(new Product(name, imageUrl, id, price, createdAt));
			}
			return list;	
		}
	}
}