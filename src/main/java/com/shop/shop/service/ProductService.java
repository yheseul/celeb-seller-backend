package com.shop.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.shop.dao.ProductDao;
import com.shop.shop.dto.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	@Transactional
	public void insertProduct(Product p) throws Exception {
		productDao.insertProduct(p);
	}
	
	public List<Product> getAllProducts() throws Exception {
		return productDao.getAllProducts();
	}
	
}