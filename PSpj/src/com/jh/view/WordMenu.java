package com.jh.view;

import java.util.Scanner;

import com.jh.controller.WordController;
import com.jh.model.vo.Member;

public class WordMenu {
	Scanner sc = new Scanner(System.in);
	WordController wc = new WordController();
	
	public void wordMenu(Member m) {
		
		boolean isLoop = true;
		while(isLoop) {	
			System.out.println("======= "+m.getUserName()+"의 단어장 =======");
			System.out.println("1. 단어 추가");
			System.out.println("2. 단어 삭제");
			System.out.println("3. 단어 수정");
			System.out.println("4. 단어 검색");
			System.out.println("5. 단어 전체 보기");
			System.out.println("6. 단어 퀴즈");
			System.out.println("7. 단어장 등록");
			System.out.println("8. 등록된 단어장 보기");
			System.out.println("9. 로그아웃");
			System.out.print("메뉴 번호 : ");
		
		
			switch(sc.nextInt()) {
				case 1:{
					addWord(m.getUserNo());
				}break;
				case 2:{
					deleteWord(m.getUserNo());
				}break;
				case 3:{
					
				}break;
				case 4:{
					
				}break;
				case 5:{
					wc.showAllWord(m.getUserNo());
				}break;
				case 6:{
					
				}break;
				case 7:{
					
				}break;
				case 8:{
					
				}break;
				case 9:{
					isLoop=false;
					System.out.println("로그아웃 되었습니다.");
				}break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	
	
	
	public void addWord(int userNo) {
		
		System.out.print("영단어를 입력하세요. : ");
		String eng = sc.next();
		System.out.print("한글을 입력하세요. : ");
		String kor = sc.next();
		
		wc.addWord(userNo, eng, kor);
	}
	
	
	
	public void deleteWord(int userNo) {
		
		System.out.print("삭제할 영단어를 입력하세요. : ");
		String eng = sc.next();
		
		wc.deleteWord(userNo, eng);
	}
	
	
	
	
	
	
	
	
	
}
