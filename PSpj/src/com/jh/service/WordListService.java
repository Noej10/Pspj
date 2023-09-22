package com.jh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.jh.common.JDBCTemplate;
import com.jh.model.dao.WordListDao;
import com.jh.model.vo.Word;
import com.jh.model.vo.WordList;

public class WordListService {

	
	public int addList(int userNo, ArrayList<Word> list, String wordListTitle, String wordListUser) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new WordListDao().addList(conn,userNo,list,wordListTitle,wordListUser);
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	public ArrayList<WordList> showWordList(){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<WordList> list = new WordListDao().showWordList(conn);
		JDBCTemplate.close(conn);
		
		
		return list;
	}
	
	
	public ArrayList<Word> showWordListWord(int userNo, String wordListTitle, String wordListUser) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Word> list = new WordListDao().showWordListWord(conn,userNo,wordListTitle,wordListUser);
		
		
		return list;
		
	}
	
	public int addToMyWord(ArrayList<Word> wl,int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new WordListDao().addToMyWord(conn,wl,userNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public void quizStart(String wordListTitle, int userNo, int point, String esTime) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new WordListDao().quizStart(conn,wordListTitle,userNo,point,esTime);
		
		if(result>0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
	}
	
//	public void quizEnd(int quizNo, int point) {
//		Connection conn = JDBCTemplate.getConnection();
//		int result = new WordListDao().quizEnd(conn,quizNo,point);
//		
//		if(result>0)
//			JDBCTemplate.commit(conn);
//		else
//			JDBCTemplate.rollback(conn);
//		
//		JDBCTemplate.close(conn);
//	}
//	
//	public int takeQuizNo(String wordListTitle,int userNo) {
//		Connection conn = JDBCTemplate.getConnection();
//		int quizNo = new WordListDao().takeQuizNo(conn,wordListTitle,userNo);
//		
//		return quizNo;
//	}
	
}
