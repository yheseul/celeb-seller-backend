package com.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.shop.dao.MemberDao;
import com.shop.shop.dto.Member;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	@Transactional
	public void insertMember(Member m) throws Exception {
		memberDao.insertMember(m);
	}
	
	public Member login(Member m) throws Exception {
		return memberDao.login(m);
	}
}
