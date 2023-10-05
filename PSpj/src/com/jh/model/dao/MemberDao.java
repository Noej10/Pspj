package com.jh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jh.common.JDBCTemplate;
import com.jh.model.vo.Member;

public class MemberDao {

	
	public int joinMembership(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO TB_MEMBER(USER_NO,USER_ID,USER_PW,USER_NAME) VALUES(SEQ_USERNO.NEXTVAL,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPw());
			pstmt.setString(3, m.getUserName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	public int exitMembership(Connection conn, String id, String pw) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM TB_MEMBER WHERE USER_ID = ? AND USER_PW = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	
	
	public Member login(Connection conn, String id, String pw) {
		
		Member m = null; 
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		
		String sql = "SELECT * FROM TB_MEMBER WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rSet = pstmt.executeQuery();
			
			if(rSet.next()) {
				m = new Member();
				m.setUserNo(rSet.getInt("USER_NO"));
				m.setUserId(rSet.getString("USER_ID")); 
				m.setUserPw(rSet.getString("USER_PW"));
				m.setUserName(rSet.getString("USER_NAME"));
				m.setFailKey(rSet.getInt("USER_FAILKEY"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}
		
		 
			
		return m;
		
	}
	
	public Member loginForPassword(Connection conn, String id, String name) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		
		String sql = "SELECT * FROM TB_MEMBER WHERE USER_ID = ? AND USER_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			rSet = pstmt.executeQuery();
			
			if(rSet.next()) {
				m = new Member();
				m.setUserNo(rSet.getInt("USER_NO"));
				m.setUserId(rSet.getString("USER_ID")); 
				m.setUserPw(rSet.getString("USER_PW"));
				m.setUserName(rSet.getString("USER_NAME"));
				m.setFailKey(rSet.getInt("USER_FAILKEY"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}
	
	
	public int changePassword(Connection conn, String id, String pw) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE TB_MEMBER SET USER_PW = ?, USER_FAILKEY = 0 WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	
	public int addFailKey(Connection conn, String id, int failKey) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE TB_MEMBER SET USER_FAILKEY = ? WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, failKey);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return result;
	}
	
}
