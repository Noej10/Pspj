package com.jh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jh.common.JDBCTemplate;
import com.jh.model.vo.Member;
import com.jh.model.vo.Word;

public class WordDao {
	
	
	public int addWord(Connection conn, int userNo, String eng, String kor) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO TB_WORD VALUES(?,?,?)";
		
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
	
	
	public int deleteAllWord(Connection conn,int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM TB_WORD WHERE USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	
	
	public ArrayList<Word> showAllWord(Connection conn, int userNo) {
		
		ResultSet rSet = null;
		PreparedStatement pstmt = null;
		ArrayList<Word> list = new ArrayList<Word>();
		
		String sql = "SELECT * FROM TB_WORD WHERE USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rSet = pstmt.executeQuery();
			
			
			while(rSet.next()) {
				
				Word w = new Word();
				w.setUserNO(rSet.getInt("USER_NO"));
				w.setWordEng(rSet.getString("WORD_ENG"));
				w.setWordKor(rSet.getString("WORD_KOR"));
				w.setWordListNo(0);
				
				list.add(w);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}
		
		
		return list;
	
	}
	
	
	public int updateWord(Connection conn, int userNo, String eng, Word w) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE TB_WORD SET WORD_ENG = ?, WORD_KOR = ? WHERE USER_NO= ? AND WORD_ENG = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, w.getWordEng());
			pstmt.setString(2, w.getWordKor());
			pstmt.setInt(3, userNo);
			pstmt.setString(4, eng);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	
	public ArrayList<Word> searchEng(Connection conn, int userNo, String eng) {
		
		ResultSet rSet = null;
		PreparedStatement pstmt = null;
		ArrayList<Word> list = new ArrayList<Word>();
		
		String sql = "SELECT * FROM TB_WORD WHERE WORD_ENG = ? AND USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, eng);
			pstmt.setInt(2, userNo);
			
			rSet = pstmt.executeQuery();
			
			while(rSet.next()) {
				Word w = new Word();
				w.setUserNO(rSet.getInt("USER_NO"));
				w.setWordEng(rSet.getString("WORD_ENG"));
				w.setWordKor(rSet.getString("WORD_KOR"));
				w.setWordListNo(0);
				
				list.add(w);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return list;
	}
	
	
	
public ArrayList<Word> searchKor(Connection conn, int userNo, String kor) {
		
		ResultSet rSet = null;
		PreparedStatement pstmt = null;
		ArrayList<Word> list = new ArrayList<Word>();
		
		String sql = "SELECT * FROM TB_WORD WHERE WORD_KOR = ? AND USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, kor);
			pstmt.setInt(2, userNo);
			
			rSet = pstmt.executeQuery();
			
			while(rSet.next()) {
				Word w = new Word();
				w.setUserNO(rSet.getInt("USER_NO"));
				w.setWordEng(rSet.getString("WORD_ENG"));
				w.setWordKor(rSet.getString("WORD_KOR"));
				w.setWordListNo(0);
				
				list.add(w);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return list;
	}
	
	
	
	
	
}
