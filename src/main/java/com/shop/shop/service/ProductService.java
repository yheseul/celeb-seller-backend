package com.shop.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.shop.dao.ProductDao;
import com.shop.shop.dto.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllProducts() throws Exception {
		return productDao.getAllProducts();
	}
	
}