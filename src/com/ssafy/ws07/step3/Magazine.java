package com.ssafy.ws07.step3;

public class Magazine extends Book {
	private int year;
	private int month;

	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month, int quantity) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(String.format(" %-10d\t|", this.getYear()));
		sb.append(String.format(" %-10d\t", this.getMonth()));
		
		return String.valueOf(sb);
//		return String.format("%-10s\t| %-10s\t| %-10s\t| %-10s\t| %-10d | %-10s\t| %-10d\t| %-10d", super.getIsbn(), super.getTitle(), super.getAuthor(), super.getPublisher(), super.getPrice(), super.getDesc(), this.getYear(), this.getMonth());
	}
}
