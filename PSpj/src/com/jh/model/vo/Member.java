package com.jh.model.vo;

public class Member {
	
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private int failKey;
	
	
	
	public Member() {
		
	}


	public Member(int userNo, String userId, String userPw, String userName, int failKey) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.failKey = failKey;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getFailKey() {
		return failKey;
	}


	public void setFailKey(int failKey) {
		this.failKey = failKey;
	}
	
	
	


	@Override
	public String toString() {
		return userNo + ", " + userId + ", " + userPw + ", " + userName;
	}
	
	
	
	
}
