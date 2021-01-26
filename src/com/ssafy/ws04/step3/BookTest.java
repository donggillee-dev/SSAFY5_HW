package com.ssafy.ws04.step3;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookManager bm = new BookManager();
		
		bm.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bm.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bm.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		
		for(Book book : bm.getList()) {
			if(book == null) break;
			System.out.println(book);
		}
		
		Book searchBook = bm.searchByisbn("21424");
		if(searchBook != null) {
			System.out.println(searchBook);
		}
		
		
		bm.remove("21424");
		
		for(Book book : bm.getList()) {
			if(book == null) break;
			System.out.println(book);
		}
	}

}
