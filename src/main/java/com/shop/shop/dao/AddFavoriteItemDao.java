package com.shop.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.shop.dto.AddFavoriteItem;

@Mapper
public interface AddFavoriteItemDao {
    List<AddFavoriteItem> getAllAddFavoriteItems() throws Exception;

    void insertAddFavoriteItem(AddFavoriteItem p) throws Exception;
}