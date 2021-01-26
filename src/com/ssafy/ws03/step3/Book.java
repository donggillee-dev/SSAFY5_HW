package com.ssafy.ws03.step3;

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	public Book() {
		
	}

	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	public String toString() {      
		return String.format("%-10s\t| %-10s\t| %-10s\t | %-10s\t| %-10d | %-10s", isbn, title, author, publisher, price, desc);
	}
}
