package com.jh.model.vo;

public class QuizWord {
	
	private String wordEng;
	private String wordKor;
	private String quizResult;
	
	
	
	public QuizWord() {
		super();
	}



	public QuizWord(String wordEng, String wordKor, String quizResult) {
		this.wordEng = wordEng;
		this.wordKor = wordKor;
		this.quizResult = quizResult;
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



	public String getQuizResult() {
		return quizResult;
	}



	public void setQuizResult(String quizResult) {
		this.quizResult = quizResult;
	}



	@Override
	public String toString() {
		return wordEng+"\t"+wordKor+"\t"+quizResult;
	}
	
	
	
}
