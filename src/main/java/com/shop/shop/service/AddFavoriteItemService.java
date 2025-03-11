package com.shop.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.shop.dao.AddFavoriteItemDao;
import com.shop.shop.dto.AddFavoriteItem;

@Service
public class AddFavoriteItemService {
	@Autowired
	AddFavoriteItemDao addFavoriteItemService;
	
	@Transactional
	public void insertAddFavoriteItem(AddFavoriteItem p) throws Exception {
		addFavoriteItemService.insertAddFavoriteItem(p);
	}
	
	public List<AddFavoriteItem> getAllAddFavoriteItems() throws Exception {
		return addFavoriteItemService.getAllAddFavoriteItems();
	}
}
