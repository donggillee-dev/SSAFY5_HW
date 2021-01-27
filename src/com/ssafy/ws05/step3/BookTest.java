package com.ssafy.ws05.step3;

public class BookTest {
	public static void main(String[] args) {
		BookManager bookManager = new BookManager();

		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bookManager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		bookManager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1));

		for(Book book : bookManager.getList()) {
			System.out.println(book);
		}
		
		for(Book book : bookManager.getBooks()) {
			System.out.println(book);
		}
		
		for(Book book : bookManager.getMagazine()) {
			System.out.println(book);
		}
		
		for(Book book : bookManager.searchByTitle("Java")) {
			System.out.println(book);
		}
		
		System.out.println("도서 가격 총합: " + bookManager.getTotalPrice());
		
		System.out.println("도서 가격 평균: " + bookManager.getPriceAvg());
	}

}