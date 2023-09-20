package com.jh.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.jh.model.vo.Word;
import com.jh.model.vo.WordList;
import com.jh.service.WordListService;
import com.jh.service.WordService;

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
	}
	

}
