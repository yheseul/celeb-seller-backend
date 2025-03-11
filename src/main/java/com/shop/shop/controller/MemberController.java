package com.shop.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<String> login(@RequestBody Member m, HttpServletRequest request) {
		try {
			m=memberService.login(m);
			if(m!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("member", m);
				return ResponseEntity.ok().body("로그인 성공");
			}else {
				// 뭔가.. 그 아디나 비번 틀렸다는 정확한 피드백주기...ㅇㅅㅇ(or 없는 계정);
				return ResponseEntity.status(401).body("다시 로그인 해주세요");
			}
		} catch (Exception e) {			
			e.printStackTrace();
			return ResponseEntity.status(500).body("서버 오류, 다시 시도해주세요.");
		}
	}
	
	@PostMapping("logout")
	public ResponseEntity<String> logout (HttpServletRequest request) {
		try {
			HttpSession session=request.getSession(false);
			if(session != null) {
				session.invalidate();
			}
			return ResponseEntity.ok().body("로그아웃 성공");
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("서버 오류, 다시 시도해주세요.");
		}
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
	
	@GetMapping("getLoggedInUser")
	public Member getLoggedInUser(HttpServletRequest request) {
	    HttpSession session = request.getSession(true);
	    if(session != null) {
	        Member member = (Member) session.getAttribute("member");
	        return member;
	    }
	    return null;
	}
}
