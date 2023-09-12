package com.jh.service;

import java.sql.Connection;

import com.jh.common.JDBCTemplate;
import com.jh.model.dao.WordDao;

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

}
