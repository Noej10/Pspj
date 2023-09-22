package com.jh.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jh.common.JDBCTemplate;
import com.jh.model.vo.Quiz;
import com.jh.model.vo.Word;
import com.jh.model.vo.WordList;

public class WordListDao {
	
	
	public int addList(Connection conn,int userNo,ArrayList<Word> list, String wordListTitle, String wordListUser) {
		// 워드리스트 넘 굳이 필요한가	삭제할수도? 심지어 워드 리스트마다 넘버 들어가지도 않고 단어마다 잡힘
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO TB_WORDLIST VALUES(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<list.size(); i++) {
			
			pstmt.setString(1, wordListTitle);
			pstmt.setString(2, wordListUser);
			pstmt.setString(3, list.get(i).getWordEng());
			pstmt.setString(4, list.get(i).getWordKor());
			pstmt.setInt(5, userNo);
			
			result += pstmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	
	
	public ArrayList<WordList> showWordList(Connection conn){
		ArrayList<WordList> list = new ArrayList<WordList>();
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		
		String sql = "SELECT WORDLIST_TITLE, WORDLIST_USER, USER_NO FROM TB_WORDLIST GROUP BY WORDLIST_TITLE, WORDLIST_USER, USER_NO";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rSet = pstmt.executeQuery();
			
			while(rSet.next()) {
				WordList wl = new WordList();
				wl.setWordListTitle(rSet.getString("WORDLIST_TITLE"));
				wl.setWordListUser(rSet.getString("WORDLIST_USER"));
				wl.setUserNo(rSet.getInt("USER_NO"));
				
				list.add(wl);
			}
			
			
	
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return list;
	}
	
	
	public ArrayList<Word> showWordListWord(Connection conn, int userNo, String wordListTitle, String wordListUser) {
		ArrayList<Word> list = new ArrayList<Word>();
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		
		String sql="SELECT WORDLIST_ENG, WORDLIST_KOR FROM TB_WORDLIST WHERE USER_NO =? AND WORDLIST_TITLE=? AND WORDLIST_USER =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, wordListTitle);
			pstmt.setString(3, wordListUser);
			
			rSet = pstmt.executeQuery();
			
			while(rSet.next()) {
				Word w = new Word();
				w.setWordEng(rSet.getString("WORDLIST_ENG"));
				w.setWordKor(rSet.getString("WORDLIST_KOR"));
				
				list.add(w);
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int addToMyWord(Connection conn, ArrayList<Word> wl, int userNo){
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql="INSERT INTO TB_WORD VALUES(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<wl.size(); i++) {
			pstmt.setInt(1, userNo);
			pstmt.setString(2, wl.get(result).getWordEng());
			pstmt.setString(3, wl.get(result).getWordKor());
			
			result += pstmt.executeUpdate();
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
		
		
	}
	
	
	public int quizStart(Connection conn,String wordListTitle, int userNo, int point, String esTime) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO TB_QUIZ VALUES(SEQ_QUIZNO.NEXTVAL,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, point);
			pstmt.setString(2, esTime);
			pstmt.setString(3, wordListTitle);
			pstmt.setInt(4, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
//	public int quizEnd(Connection conn,int quizNo, int point) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//		
//		String sql = "UPDATE TB_QUIZ SET QUIZ_POINT = ?, QUIZ_ENDDATE = SYSDATE WHERE QUIZ_NO = ?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1, point);
//			pstmt.setInt(2, quizNo);
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(pstmt);
//		}
//		
//		return result;
//	}
//	
//	
	public int takeQuizNo(Connection conn, String wordListTitle, int userNo) {
		int quizNo = 0;
		ResultSet rSet = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM TB_QUIZ WHERE QUIZ_TITLE = ? AND QUIZ_USER_NO = ? ORDER BY QUIZ_NO DESC";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, wordListTitle);
			pstmt.setInt(2, userNo);
			
			rSet = pstmt.executeQuery();
			
			if(rSet.next()) {
				quizNo = rSet.getInt("QUIZ_NO");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return quizNo;
		
	}
	
	
	public ArrayList<Quiz> showQuizrecord(Connection conn, String wordListTitle) {
		ResultSet rSet = null;
		PreparedStatement pstmt = null;
		ArrayList<Quiz> list = new ArrayList<Quiz>();
		
		String sql = "SELECT QUIZ_POINT, QUIZ_TIME, USER_ID FROM TB_QUIZ JOIN TB_MEMBER ON QUIZ_USER_NO = USER_NO WHERE QUIZ_TITLE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, wordListTitle);
			
			rSet = pstmt.executeQuery();
			
			while(rSet.next()) {
				Quiz quizRecord = new Quiz();
				quizRecord.setQuizPoint(rSet.getInt("QUIZ_POINT"));
				quizRecord.setQuizTime(rSet.getString("QUIZ_TIME"));
				quizRecord.setuserId(rSet.getString("USER_ID"));
				
				list.add(quizRecord);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return list;
		
	}
	
	
}
