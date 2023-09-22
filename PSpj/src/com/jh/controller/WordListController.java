package com.jh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.jh.model.vo.Quiz;
import com.jh.model.vo.QuizWord;
import com.jh.model.vo.Word;
import com.jh.model.vo.WordList;
import com.jh.service.WordListService;
import com.jh.service.WordService;
			// 단어장 가져와서 단어 퀴즈 & 기록
			// DATE 사용해서 기록에 퀴즈시작시간/퀴즈종료시간/퀴즈소요시간 
public class WordListController {
	
	Scanner sc = new Scanner(System.in);
	
	public void addList(int userNo,String wordListTitle, String wordListUser) {
		
		ArrayList<Word> list = new WordService().showAllWord(userNo);
		int result = new WordListService().addList(userNo,list,wordListTitle,wordListUser);
		
		if(result>0) {
			System.out.println("단어장이 정상적으로 등록되었습니다.");
		}else {
			System.out.println("단어장 등록에 실패했습니다.");
		}
		
	}
	
	
	public void showWordList(int userNo) {
		ArrayList<WordList> list = new WordListService().showWordList();
		System.out.println("번호\t제목\t작성자");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println((i+1)+"\t"+list.get(i));
		}
		
		System.out.println("확인하고 싶은 단어장의 번호를 입력하세요.");
		System.out.print("단어장 번호 : ");
		int selnum = sc.nextInt();
		
		ArrayList<Word> wl = new WordListService().showWordListWord(list.get(selnum-1).getUserNo(),list.get(selnum-1).getWordListTitle(),list.get(selnum-1).getWordListUser());
		
		System.out.println("영어\t한국어");
		for(Word wo : wl) {
			System.out.println(wo);
		}
		
		System.out.println("1. 내 단어장에 추가");
		System.out.println("2. 단어 퀴즈");
		System.out.println("3. 단어 퀴즈 기록 보기");
		System.out.println("9. 뒤로");
		
		switch(sc.nextInt()) {
			case 1:{
				addToMyWord(wl,userNo);
			}break;
			case 2:{
				wordListQuiz(list.get(selnum-1).getWordListTitle(),wl,userNo);
			}break;
			case 3:{
				showQuizrecord(list.get(selnum-1).getWordListTitle());
			}break;
			case 9:{
				
			}break;
			default:
		}
				
	}
	
	
	public void addToMyWord(ArrayList<Word> wl, int userNo) {
		int result = new WordListService().addToMyWord(wl,userNo);
		
		if(result>0) {
			System.out.println("단어를 정상적으로 저장했습니다.");
		}else {
			System.out.println("단어를 저장할 수 없습니다.");
		}
	}
	
	public void wordListQuiz(String wordListTitle,ArrayList<Word> wl, int userNo) {
		
		ArrayList<QuizWord> quizResult = new ArrayList<QuizWord>();
		int point = 0;
		Set<Integer> set = new HashSet<Integer>();

		
		
		//여기서 처음 인설트 하면서 시작 시간 잡아주고
		Date sTime = new Date();
		
		


		
		while(set.size()!=10) {
			set.add((int)(Math.random()*wl.size()));
		}
		// 자바 안에서 시간 찍을 수 있는거
		for(int s : set) {
			String quest = wl.get(s).getWordKor();
			String answer;
			
			System.out.print(quest+"의 영어 단어를 입력하세요. : ");
			answer=sc.next();
			
			
			if(wl.get(s).getWordEng().equals(answer)) {
				point += 10;
				quizResult.add(new QuizWord(wl.get(s).getWordEng(), wl.get(s).getWordKor(), "O"));
			}
			else
				quizResult.add(new QuizWord(wl.get(s).getWordEng(), wl.get(s).getWordKor(), "X"));
		}
		
		System.out.println("번호\t영어\t한글\t정답여부");
		for(int i=0; i<quizResult.size(); i++) {
			System.out.println((i+1)+"\t"+quizResult.get(i).toString());
		}
		System.out.println("당신의 점수는 "+point+"점 입니다.");
		
		Date eTime = new Date();
		
		
		long tTimeM = (eTime.getTime() - sTime.getTime()) / 60000;
		long tTimeS = (eTime.getTime() - sTime.getTime()) / 1000;
		String esTime = tTimeM + ":" + tTimeS;
		
		
		System.out.println("걸린시간 : "+esTime);
		
		
		
		new WordListService().quizStart(wordListTitle,userNo,point,esTime);
		
		
//		new WordListService().quizEnd(quizNo,point);
		//여기서 끝나는 시간 잡아주면서 최종 걸린 시간,포인트 잡아주고
		
		
	}
	
	
	
	public void showQuizrecord(String wordListTitle) {
		
		ArrayList<Quiz> list = new WordListService().showQuizrecord(wordListTitle);
		
		
		System.out.println("점수\t걸린시간\t회원아이디");
		for(Quiz q : list) {
			System.out.println(q);
		}
		
	}
	
	
	

}
