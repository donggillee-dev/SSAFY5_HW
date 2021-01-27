package com.ssafy.ws05.step3;

import java.util.Arrays;

public class BookManager {
	private int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;
	
	public void add(Book book) {
		if(MAX_SIZE > size) {
			books[size] = book;
			size++;	
		}
	}
	
	public void remove(String isbn) {
		for(int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[size - 1];
				books[size - 1] = null;
				size--;
				break;
			}
		}
	}
	
	public Book[] getList() {
		System.out.println("**************************도서 전체 목록***************************");
		Book[] results = null;
		int cnt = 0;
		
		for(Book book : books) {
			if(book != null) {
				cnt++;
			} else {
				break;
			}
		}
		
		results = new Book[cnt];
		
		results = Arrays.copyOf(books, cnt);
		
		return results;
	}
	
	public Book searchByisbn(String isbn) {
		Book result = null;
		
		for(Book book : books) {
			if(book == null) {
				break;
			} else if(book.getIsbn().equals(isbn)) {
				result = book;
				break;
			} else;
		}
		
		return result;
	}
	
	public Book[] searchByTitle(String Title) {
		System.out.println("**********************도서 제목 포함검색:" + Title + "***********************");
		int cnt = 0;
		Book[] results = null;
		
		for(Book book : books) {
			if(book == null) {
				break;
			} else if(book.getTitle().contains(Title)){
				cnt++;
			} else;
		}
		
		results = new Book[cnt];
		cnt = 0;
		
		for(Book book : books) {
			if(book == null) {
				break;
			} else if(book.getTitle().contains(Title)) {
				results[cnt] = book;
				cnt++;
			} else;
		}
		
		return results;
	}
	
	public Book[] getBooks() {
		System.out.println("**************************일반 전체 목록***************************");
		int cnt = 0;
		Book[] results = null;
		
		for(Book book : books) {
			if(book instanceof Book) {
				cnt++;
			} else if( book == null) {
				break; 
			} else;
		}
		
		results = new Book[cnt];
		cnt = 0;
		
		for(Book book : books) {
			if(book instanceof Book) {
				results[cnt] = book;
				cnt++;
			} else if(book == null) {
				break;
			} else;
		}
		
		return results;
	}
	
	public Book[] getMagazine() {
		System.out.println("****************************잡지 목록*****************************");
		int cnt = 0;
		Book[] results = null;
		
		for(Book book : books) {
			if(book instanceof Magazine) {
				cnt++;
			} else if( book == null) {
				break; 
			} else;
		}
		
		results = new Book[cnt];
		cnt = 0;
		
		for(Book book : books) {
			if(book instanceof Magazine) {
				results[cnt] = book;
				cnt++;
			} else if(book == null) {
				break;
			} else;
		}
		
		return results;
	}
	
	public int getTotalPrice() {
		int sum = 0;
		
		for(Book book : books) {
			if(book == null) {
				break;
			} else {
				sum += book.getPrice();
			}
		}
		
		return sum;
	}
	
	public double getPriceAvg() {
		double avg = this.getTotalPrice() / (double)size;
		
		return avg;
	}
}
