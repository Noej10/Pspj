package com.jh.view;

import java.util.Scanner;

import com.jh.controller.WordController;
import com.jh.controller.WordListController;
import com.jh.model.vo.Member;

public class WordMenu {
	Scanner sc = new Scanner(System.in);
	WordController wc = new WordController();
	WordListController wlc = new WordListController();
	public void wordMenu(Member m) {
		
		boolean isLoop = true;
		while(isLoop) {	
			System.out.println("\n======= "+m.getUserName()+"의 단어장 =======");
			System.out.println("1. 단어 추가");
			System.out.println("2. 단어 삭제");
			System.out.println("3. 단어 수정");
			System.out.println("4. 단어 검색");
			System.out.println("5. 단어 전체 보기");
			System.out.println("6. 단어 퀴즈");
			System.out.println("7. 내 단어장 등록");
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
					updateWord(m.getUserNo());
				}break;
				case 4:{
					searchWord(m.getUserNo());
				}break;
				case 5:{
					wc.showAllWord(m.getUserNo());
				}break;
				case 6:{
					quizWord(m.getUserNo());
				}break;
				case 7:{
					addList(m.getUserNo());
				}break;
				case 8:{
					showWordList(m.getUserNo());
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
		
		wc.showAllWord(userNo);
		System.out.print("삭제할 영단어를 입력하세요. : ");
		String eng = sc.next();
		
		wc.deleteWord(userNo, eng);
	}
	
	
	public void updateWord(int userNo) {
		wc.showAllWord(userNo);
		System.out.print("변경하고싶은 영단어를 입력하세요. : ");
		String eng = sc.next();
		
		System.out.print("변경할 영단어를 입력하세요. : ");
		String uEng = sc.next();
		System.out.print("변경할 한국어를 입력하세요. : ");
		String uKor = sc.next();
		
		wc.updateWord(userNo,eng,uEng,uKor);
	}
	
	
	
	public void searchWord(int userNo) {
		
		boolean isLoop = true;
		
		while(isLoop) {
			System.out.println("1. 영어로 검색");
			System.out.println("2. 한글로 검색");
			System.out.println("9. 검색 취소");
			System.out.print("검색 방법 입력 : ");
			
			
			switch(sc.nextInt()) {
				case 1:{
					System.out.print("검색할 단어(영어) 입력 : ");
					String eng = sc.next();
					wc.searchEng(userNo,eng);
				}break;
				case 2:{
					System.out.print("검색할 단어(한글) 입력 : ");
					String kor = sc.next();
					wc.searchKor(userNo,kor);
				}break;
				case 9:{
					System.out.println("메인 메뉴로 돌아갑니다.");
					return;
				}
				default:{
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}	
	}
	
	public void quizWord(int userNo) {
		boolean isLoop = true;
		System.out.println("등록한 단어들 중 10개가 무작위로 표시(한글)됩니다.");
		System.out.println("해당 단어의 영어를 입력하여 정답을 맞춰보세요!");
		
		while(isLoop) {
			System.out.print("퀴즈 시작(Y/N) : ");
			
			switch(sc.next()) {
				case "y":
				case "Y":{
					wc.quizWord(userNo);
					isLoop=false;
				}break;
				case "N":
				case "n":{
					isLoop = false;
					System.out.println("메인 메뉴로 돌아갑니다.");
				}break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void addList(int userNo) {
		System.out.println("등록될 단어장의 이름을 입력해주세요.");
		System.out.print("단어장 이름 : ");
		String wordListTitle = sc.next();
		System.out.print("표시될 작성자 이름 : ");
		String wordListUser = sc.next();
		
		wlc.addList(userNo,wordListTitle,wordListUser);
	}
	
	
	public void showWordList(int userNo) {
		wlc.showWordList(userNo);
	}
	
	
	
	
	
	
	
	
	
	
}
