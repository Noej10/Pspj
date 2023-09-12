package com.jh.service;

import java.sql.Connection;

import com.jh.common.JDBCTemplate;
import com.jh.model.dao.MemberDao;
import com.jh.model.vo.Member;

public class MemberService {
	
	
	public int joinMembership(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().joinMembership(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public Member login(String id, String pw) {
		
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().login(conn,id,pw);
		JDBCTemplate.close(conn);
		
		return m;
		
	}
	
	public Member loginForPassword(String id, String name) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().loginForPassword(conn,id,name);
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	
	public int changePassword(String id, String pw){
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().changePassword(conn,id,pw);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	public void addFailKey(String id,int failKey) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().addFailKey(conn,id,failKey);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
	}

}
