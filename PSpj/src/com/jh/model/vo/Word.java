package com.jh.model.vo;

public class Word {
	
	private int userNO;
	private String wordEng;
	private String wordKor;
	private int wordListNo;

	
	public Word() {
		
	}
	
	public int getUserNO() {
		return userNO;
	}

	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}

	public String getWordEng() {
		return wordEng;
	}

	public void setWordEng(String wordEng) {
		this.wordEng = wordEng;
	}

	public String getWordKor() {
		return wordKor;
	}

	public void setWordKor(String wordKor) {
		this.wordKor = wordKor;
	}

	public int getWordListNo() {
		return wordListNo;
	}

	public void setWordListNo(int wordListNo) {
		this.wordListNo = wordListNo;
	}

	@Override
	public String toString() {
		return wordEng + "\t" + wordKor;
	}
	
	
	
	

}
