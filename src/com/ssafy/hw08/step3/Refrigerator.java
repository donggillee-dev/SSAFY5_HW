package com.ssafy.hw08.step3;

public class Refrigerator extends Product{
	private int liter;

	public Refrigerator(int serial, String name, int price, int qty, int liter) {
		super(serial, name, price, qty);
		this.liter = liter;
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(String.format(" %-10s\t|%-10s\t|", this.getLiter(), ""));
		
		return String.valueOf(sb);
	}
}
