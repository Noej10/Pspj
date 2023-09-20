package com.jh.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.jh.model.vo.QuizWord;
import com.jh.model.vo.Word;
import com.jh.service.WordService;

public class WordController {
	
	Scanner sc = new Scanner(System.in);
	
	
	public void addWord(int userNo, String eng, String kor) {
		
		int result = new WordService().addWord(userNo, eng, kor);
		
		if(result>0) {
			System.out.println("정상적으로 단어가 저장되었습니다.");
		}else {
			System.out.println("단어 저장에 실패했습니다.");
		}
	}
	
	
	public void deleteWord(int userNo, String eng) {
		int result = new WordService().deleteWord(userNo,eng);
		
		if(result>0) {
			System.out.println("정상적으로 단어 "+eng+"가 삭제되었습니다.");
		}else
			System.out.println("단어 삭제에 실패했습니다.");
	}
	
	
	public void showAllWord(int userNo) {
		ArrayList<Word> list = new WordService().showAllWord(userNo);
		
		System.out.println("영어\t한국어");
		for(Word w : list) {
			System.out.println(w);
		}
	}
	
	
	
	
	public void updateWord(int userNo, String eng, String uEng, String uKor) {
		
		Word w = new Word();
		w.setWordEng(uEng);
		w.setWordKor(uKor);
		
		int result = new WordService().updateWord(userNo,eng,w);
		
		if(result>0) {
			System.out.println("정상적으로 단어가 변경되었습니다.");
		}else {
			System.out.println("단어 변경에 실패했습니다.");
		}
			
		
	}
	
	
	public void searchEng(int userNo, String eng) {
		ArrayList<Word> list = new WordService().searchEng(userNo,eng);
		
		System.out.println("영어\t한국어");
		for(Word w : list) {
			System.out.println(w);
		}
		
	}
	
	
	
	public void searchKor(int userNo, String kor) {
		
		ArrayList<Word> list = new WordService().searchKor(userNo,kor);
		
		System.out.println("영어\t한국어");
		for(Word w : list) {
			System.out.println(w);
		}
		
	}
	
	
	
	public void quizWord(int userNo) {
		
		ArrayList<Word> mylist = new WordService().showAllWord(userNo);
		ArrayList<QuizWord> quizResult = new ArrayList<QuizWord>();
		int point = 0;
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size()!=10) {
			set.add((int)(Math.random()*mylist.size()));
		}
		
		for(int s : set) {
			String quest = mylist.get(s).getWordKor();
			String answer;
			
			System.out.print(quest+"의 영어 단어를 입력하세요. : ");
			answer=sc.next();
			
			
			if(mylist.get(s).getWordEng().equals(answer)) {
				point += 10;
				quizResult.add(new QuizWord(mylist.get(s).getWordEng(), mylist.get(s).getWordKor(), "O"));
			}
			else
				quizResult.add(new QuizWord(mylist.get(s).getWordEng(), mylist.get(s).getWordKor(), "X"));
		}
		
		System.out.println("번호\t영어\t한글\t정답여부");
		for(int i=0; i<quizResult.size(); i++) {
			System.out.println((i+1)+"\t"+quizResult.get(i).toString());
		}
		System.out.println("당신의 점수는 "+point+"점 입니다.");
		
		
	}
	
	
	
	
	
	

}
