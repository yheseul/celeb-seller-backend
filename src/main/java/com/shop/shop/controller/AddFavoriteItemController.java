package com.shop.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shop.dto.AddFavoriteItem;
import com.shop.shop.service.AddFavoriteItemService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
public class AddFavoriteItemController {
	@Autowired
	AddFavoriteItemService addFavoriteItemService;
	
	Map<String, Object> storage =new HashMap<>();
	
	@PostMapping("/insertAddFavoriteItem")
	public Map<String, String> insertAddFavoriteItem(@RequestBody AddFavoriteItem p){
		Map<String, String> responseData=new HashMap();
		try {
			addFavoriteItemService.insertAddFavoriteItem(p);
			responseData.put("msg", "찜하기 성공");
		} catch (Exception e) {
			e.printStackTrace();
			responseData.put("msg", e.getMessage());
		}
		return responseData;
	}

}
