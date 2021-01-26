package com.ssafy.ws04.step3;

public class BookManager {
	private int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
	
	
	public void add(Book book) {		
		books[size] = book;
		size++;
	}
	
	public void remove(String isbn) {
		System.out.println("***********************도서삭제:" + isbn + "***********************");
		boolean flag = false;
		int pivot = 0;
		
		for(int i = 0; i < books.length; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = null;
				pivot = i;
				flag = true;
				break;
			}
		}
		
		if(flag) {
			books[pivot] = books[size - 1];
			books[size - 1] = null;
			size--;
		} else {
			System.out.println("**********************해당 도서가 없습니다***********************");
		}
	}
	
	public Book[] getList() {
		System.out.println("***********************도서목록***********************");
		return books;
	}
	
	public Book searchByisbn(String isbn) {
		System.out.println("***********************도서조회:" + isbn + "***********************");
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		System.out.println("**********************해당 도서가 없습니다***********************");
		return null;
	}
}
