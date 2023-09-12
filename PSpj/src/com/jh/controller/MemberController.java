package com.jh.controller;

import com.jh.model.vo.Member;
import com.jh.service.MemberService;
import com.jh.view.WordMenu;

public class MemberController {
	
	
	
	public void joinMembership(String id, String pw, String name) {
		
		Member m = new Member();
		m.setUserId(id);
		m.setUserPw(pw);
		m.setUserName(name);
		
		int result = new MemberService().joinMembership(m);
		
	}
	
	public void exitMembership() {
		
	}
	
	
	public void login(String id,String pw){
		
		Member m = new MemberService().login(id,pw);
		
		
		if(m==null) {
			System.out.println("해당 ID를 찾을 수 없습니다.");
		}else if(m.getUserId().equals(id) && !m.getUserPw().equals(pw)) {
			int failKey = m.getFailKey()+1;
			new MemberService().addFailKey(id,failKey);
			if(failKey>=3) {
				System.out.println("아이디 잠금 상태입니다. 비밀번호 변경을 통해 잠금을 해제하세요.");
				return;
			}
			
			
			System.out.println("비밀번호가 맞지 않습니다.");
			System.out.println("틀린 횟수 : "+failKey);
			System.out.println("로그인 실패 3회 시 아이디가 잠금처리됩니다.");
		}else {
			int failKey = m.getFailKey();
			
			if(failKey>=3) {
				System.out.println("아이디 잠금 상태입니다. 비밀번호 변경을 통해 잠금을 해제하세요.");
				return;
			}
			
			System.out.println("로그인 성공!");
			new WordMenu().wordMenu(m);
		}
		
	}
	
	
	public boolean loginForPassword(String id, String name) {
		Member m = new MemberService().loginForPassword(id,name);
		
		if(m==null) {
			return false;
		}else
			return true;
		
	}
	
	public void changePassword(String id, String pw) {
		int result  = new MemberService().changePassword(id,pw);
		
		if(result>0) {
			System.out.println("비밀번호 변경이 완료되었습니다.");
		}else {
			System.out.println("비밀번호 변경에 실패했습니다.");
		}
		
	}
	
}
