package com.ssafy.ws03.step3;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] bookArr = new Book[2];
		
	
		bookArr[0] = new Book("21424", "Java pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		bookArr[1] = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		
		System.out.println("*****************도서목록*****************");
		for(int i = 0; i < bookArr.length; i++) {
			System.out.println(bookArr[i].toString());
		}
		
	}

}
