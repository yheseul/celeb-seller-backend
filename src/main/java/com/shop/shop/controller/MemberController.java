package com.shop.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shop.dto.Member;
import com.shop.shop.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@PostMapping("login")
	public Map<String, String> login(@RequestBody Member m, HttpServletRequest request) {
		System.out.println(m);
		Map<String,String> responseData=new HashMap();
		try {
			m=memberService.login(m);
			if(m!=null) {
				HttpSession session=request.getSession();
				System.out.println(session.getId());
				session.setAttribute("member", m);
				responseData.put("msg","로그인 성공");
			}else {
				// 뭔가.. 그 아디나 비번 틀렸다는 정확한 피드백주기...ㅇㅅㅇ(or 없는 계정);
				responseData.put("msg","다시 로그인 해주세요");
			}
		} catch (Exception e) {			
			e.printStackTrace();
			responseData.put("msg","다시 로그인 해주세요");
		}
		return responseData;
	}
	
	@PostMapping("insertMember")
	public Map<String, String> insertMember(@RequestBody Member m) {
		Map<String,String> responseData=new HashMap();
		try {
			memberService.insertMember(m);
			responseData.put("msg","회원가입 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseData.put("msg",e.getMessage());
		}
		
		return responseData;
	}
}
