package com.shop.shop.dao;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.shop.shop.dto.Product;

@Mapper
public interface ProductDao {
    List<Product> getAllProducts() throws Exception;

	void insertProduct(Product p) throws Exception;
}
