package com.jh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jh.common.JDBCTemplate;

public class WordDao {
	
	
	public int addWord(Connection conn, int userNo, String eng, String kor) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO TB_WORD(USER_NO,WORD_ENG,WORD_KOR) VALUES(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, eng);
			pstmt.setString(3, kor);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	
	public int deleteWord(Connection conn, int userNo, String eng) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM TB_WORD WHERE USER_NO = ? AND WORD_ENG = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, eng);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
}
