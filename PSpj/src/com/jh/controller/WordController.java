package com.jh.controller;

import com.jh.service.WordService;

public class WordController {
	
	
	public void addWord(int userNo, String eng, String kor) {
		
		int result = new WordService().addWord(userNo, eng, kor);
		
		if(result>0) {
			System.out.println("정상적으로 단어가 저장되었습니다.");
		}else {
			System.out.println("단어가 저장되지 않았습니다.");
		}
	}
	
	
	public void deleteWord(int userNo, String eng) {
		int result = new WordService().deleteWord(userNo,eng);
		
		if(result>0) {
			System.out.println("정상적으로 단어 "+eng+"가 삭제되었습니다.");
		}else
			System.out.println("단어를 삭제하지 못했습니다.");
	}
	
	
	public void showAllWord(int userNo) {
		
	}

}
