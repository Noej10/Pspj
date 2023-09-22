package com.jh.model.vo;

public class Quiz {
	private int quizNo;
	private int quizPoint;
	private String quizTime;
	private String quizTitle;
	private int userNo;
	
	public Quiz() {
		
	}

	public Quiz(int quizNo, int quizPoint, String quizTime, String quizTitle, int userNo) {
		this.quizNo = quizNo;
		this.quizPoint = quizPoint;
		this.quizTime = quizTime;
		this.quizTitle = quizTitle;
		this.userNo = userNo;
	}

	public int getQuizNo() {
		return quizNo;
	}

	public void setQuizNo(int quizNo) {
		this.quizNo = quizNo;
	}

	public int getQuizPoint() {
		return quizPoint;
	}

	public void setQuizPoint(int quizPoint) {
		this.quizPoint = quizPoint;
	}

	public String getQuizTime() {
		return quizTime;
	}

	public void setQuizTime(String quizTime) {
		this.quizTime = quizTime;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}