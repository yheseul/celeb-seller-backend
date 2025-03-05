package com.shop.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shop.dto.Product;
import com.shop.shop.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("getAllProducts")
	public List<Product> getAllProducts() {
		try {
			return productService.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}
}
