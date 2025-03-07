package com.shop.shop.dao;

import com.shop.shop.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {

    Member login(Member m) throws Exception;

    void insertMember(Member m) throws Exception;
}
