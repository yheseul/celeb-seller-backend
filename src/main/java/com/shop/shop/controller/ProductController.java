package com.shop.shop.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shop.dto.Product;
import com.shop.shop.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	Map<String, Object> storage =new HashMap<>();
	
	@GetMapping("getAllProducts")
	public List<Product> getAllProducts() {
		try {
			Object o=storage.get("firstPageProducts");
			if(o==null) {
				List<Product> list = productService.getAllProducts();
				storage.put("productService", list);
				return list;
			}
			return (List<Product>)o;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}
	
	@PostMapping("insertProduct")
	public Map<String, String> insertProduct(@RequestBody Product p){
		Map<String, String> responseData=new HashMap();
		try {
			productService.insertProduct(p);
			responseData.put("msg", "상품 등록 성공");
		} catch (Exception e) {
			e.printStackTrace();
			responseData.put("msg", e.getMessage());
		}
		return responseData;
	}
}