package com.jh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	/**
	 * Connection 객체 생성해서 리턴하는 메서드
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MINIPJ", "MINIPJ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
				
	}
	
	/**
	 * 커밋 처리해주는 메서드
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 롤백 처리 해주는 메서드
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 반납 메서드 이름들은 close로 동일 오버로딩으로 구별
	
	/**
	 * Statement 관련 객체 반납해주는 메서드
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Connection 객체 반납해주는 메서드
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ResultSet 객체 반납해주는 메서드
	 * @param rSet
	 */
	public static void close(ResultSet rSet) {
		try {
			if(rSet != null && !rSet.isClosed())
			rSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
