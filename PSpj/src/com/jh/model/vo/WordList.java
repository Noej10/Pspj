package com.jh.model.vo;

public class WordList {
	
	private int wordListNo;
	private String wordListTitle;
	private String wordListUser;
	private String wordListEng;
	private String wordListKor;
	private int userNo;
	
	public WordList() {
	}

	public WordList(int wordListNo, String wordListTitle, String wordListUser, String wordListEng, String wordListKor,
			int userNo) {
		this.wordListNo = wordListNo;
		this.wordListTitle = wordListTitle;
		this.wordListUser = wordListUser;
		this.wordListEng = wordListEng;
		this.wordListKor = wordListKor;
		this.userNo = userNo;
	}

	public int getWordListNo() {
		return wordListNo;
	}

	public void setWordListNo(int wordListNo) {
		this.wordListNo = wordListNo;
	}

	public String getWordListTitle() {
		return wordListTitle;
	}

	public void setWordListTitle(String wordListTitle) {
		this.wordListTitle = wordListTitle;
	}

	public String getWordListUser() {
		return wordListUser;
	}

	public void setWordListUser(String wordListUser) {
		this.wordListUser = wordListUser;
	}

	public String getWordListEng() {
		return wordListEng;
	}

	public void setWordListEng(String wordListEng) {
		this.wordListEng = wordListEng;
	}

	public String getWordListKor() {
		return wordListKor;
	}

	public void setWordListKor(String wordListKor) {
		this.wordListKor = wordListKor;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return wordListTitle + "\t" + wordListUser;
	}
	
	
	
	
	
	
}
