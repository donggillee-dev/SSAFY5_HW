package com.ssafy.ws01.step3;

public class DigitTest2 {
	public static void main(String[] args) {
		int count = 1;
		boolean isIncrease = true;
		int blank = 0;
		
		for(int i = 0; i < 7; i++) {
			
			for(int j = 0; j < blank; j++) {
				System.out.printf("%4s", " ");
			}
			
			for(int j = 0; j < 7 - ( blank * 2 ); j++) {
				System.out.printf("%4d", count);
				count++;
			}
			
			System.out.println();
			
			if(isIncrease) {
				blank++;
			} else {
				blank--;
			}
			
			if(blank == 3) {
				isIncrease = false;
			}
		}
	}
}
