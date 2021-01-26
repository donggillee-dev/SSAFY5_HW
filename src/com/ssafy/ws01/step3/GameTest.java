package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest{
	public static void main(String[] args){
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.println("번호를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		
		int menu = sc.nextInt();
		
		int comWin = 0;
		int usrWin = 0;
		int totalCnt = 0;
		int winCnt = 0;
		int gameCnt = 0;
		int comNo = 0;
		int usrNo = 0;
		
		if(menu == 1) {
			totalCnt = 5;
			winCnt = 3;
		} else if(menu == 2) {
			totalCnt = 3;
			winCnt = 2;
		} else {
			totalCnt = 1;
			winCnt = 1;
		}
		
		while(gameCnt++ < totalCnt && (comWin<winCnt && usrWin<winCnt)) {
			System.out.println("가위(1), 바위(2), 보(3) 중 하나 입력 : ");
			usrNo = sc.nextInt();
			comNo = (int) (Math.random() * 3 + 1);
			
			
			if(comNo == 1) {
				if(usrNo == 1) {
					System.out.println("비겼습니다");
				} else if(usrNo == 2) {
					usrWin++;
					System.out.println("이겼습니다");
				} else {
					comWin++;
					System.out.println("졌습니다");
				}
			} else if(comNo == 2) {
				if(usrNo == 2) {
					System.out.println("비겼습니다");
				} else if(usrNo == 3) {
					usrWin++;
					System.out.println("이겼습니다");
				} else {
					comWin++;
					System.out.println("졌습니다");
				}
			} else {
				if(usrNo == 3) {
					System.out.println("비겼습니다");
				} else if(usrNo == 1) {
					usrWin++;
					System.out.println("이겼습니다");
				} else {
					comWin++;
					System.out.println("졌습니다");
				}
			}

		}
		if(usrWin > comWin) {
			System.out.println("### 사용자 승!!!");
		} else if(usrWin < comWin) {
			System.out.println("### 컴퓨터 승!!!");
		} else {
			System.out.println("### 무승부!!!");
		}
		
		sc.close();
	}
}
