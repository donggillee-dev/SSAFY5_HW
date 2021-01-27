package com.ssafy.ws05.step3;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;

	public Book() {
		super();
	}

	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format(" %-10s\t|", this.getIsbn()));
		sb.append(String.format(" %-10s\t|", this.getTitle()));
		sb.append(String.format(" %-10s\t|", this.getAuthor()));
		sb.append(String.format(" %-10s\t|", this.getPublisher()));
		sb.append(String.format(" %-10d|", this.getPrice()));
		sb.append(String.format(" %-10s\t|", this.getDesc()));
		
		return String.valueOf(sb);
//		return String.format("%-10s\t| %-10s\t| %-10s\t| %-10s\t| %-10d | %-10s", this.getIsbn(), this.getTitle(), this.getAuthor(), this.getPublisher(), this.getPrice(), this.getDesc());
	}
}
