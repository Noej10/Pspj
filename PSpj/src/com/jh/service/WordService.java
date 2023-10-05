package com.jh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.jh.common.JDBCTemplate;
import com.jh.model.dao.WordDao;
import com.jh.model.vo.Word;

public class WordService {
	
	
	
	public int addWord(int userNo, String eng, String kor) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new WordDao().addWord(conn,userNo,eng,kor);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else
			JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int deleteWord(int userNo, String eng) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new WordDao().deleteWord(conn, userNo, eng);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	public void deleteAllWord(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new WordDao().deleteAllWord(conn,userNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
	}
	
	
	public ArrayList<Word> showAllWord(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Word> list = new WordDao().showAllWord(conn, userNo);
		JDBCTemplate.close(conn);
		
		
		return list;
	}
	
	
	public int updateWord(int userNo, String eng, Word w) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new WordDao().updateWord(conn, userNo, eng, w);
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		JDBCTemplate.close(conn);
		
		
		
		
		
		return result;
	}
	
	
	public ArrayList<Word> searchEng(int userNo, String eng) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Word> list = new WordDao().searchEng(conn,userNo,eng);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}
	
	public ArrayList<Word> searchKor(int userNo, String kor) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Word> list = new WordDao().searchKor(conn,userNo,kor);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}
	
	
	

}
