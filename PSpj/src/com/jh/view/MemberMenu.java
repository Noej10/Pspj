package com.jh.view;

import java.util.Scanner;

import com.jh.controller.MemberController;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	/**
	 * 로그인 메인 메뉴
	 */
	public void memberMainMenu() {
		
		
		while(true) {
			System.out.println("== 단 어 장 로 그 인 ==");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 회원탈퇴");
			System.out.println("4. 비밀번호 변경");
			System.out.println("9. 프로그램 종료");
			
			
			System.out.print("숫자를 입력하세요. : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1:{
					login();
				}break;
				case 2:{
					joinMembership();
				}break;
				case 3:{
					exitMembership();
				}break;
				case 4:{
					changePassword();
				}break;
				case 9:{
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				default:{
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
			
		}
		
	}

	
	
	public void joinMembership() {
		System.out.println("== 회 원 가 입 ==");
		
		System.out.print("ID를 입력해주세요.");
		String id = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요.");
		String pw= sc.nextLine();
		
		System.out.print("이름을 입력해주세요.");
		String name = sc.nextLine();
		
		mc.joinMembership(id,pw,name);
		
	}
	
	public void exitMembership() {
		System.out.println("아이디와 비밀번호를 입력해주세요.");
		
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("정말로 탈퇴하시겠습니까?(Y/N) : ");
		
		switch(sc.next().toUpperCase().charAt(0)){
			case 'Y':{
				mc.exitMembership();
			}break;
			case 'N':{
				System.out.println("메인 메뉴로 돌아갑니다.");
			}break;
			default :{
				System.out.println("잘못 입력하여 메인 메뉴로 돌아갑니다.");
			}
		}
	}
	
	public void login() {
		System.out.println("아이디와 비밀번호를 입력해주세요.");
		
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		mc.login(id,pw);
		
	}
	
	
	public void changePassword() {
		System.out.println("아이디와 이름을 입력해주세요.");
		
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		
		boolean isRight = mc.loginForPassword(id,name);
		
		
		if(isRight) {
		System.out.print("변경할 비밀번호를 입력해주세요. : ");
		String pw = sc.next();
		
		mc.changePassword(id,pw);
		
		}else {
			System.out.println("잘못 입력하셨습니다. 메인 메뉴로 돌아갑니다.");
		}
		
	}
	
	

	
	
	
}
