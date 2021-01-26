package com.ssafy.algo;

import java.util.*;

public class DigitTest1 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int[] arr = new int[10];
			
			while(true) {
				int input = sc.nextInt();
				
				if(input == 0) {
					break;
				} else {
					arr[input / 10]++;
				}
			}
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != 0) {
					System.out.print(i + " : " + arr[i] + "개\n");	
				}
			}
		}
	}
}
