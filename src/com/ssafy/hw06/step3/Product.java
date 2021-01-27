package com.ssafy.hw06.step3;

public class Product {
	private int serial;
	private String name;
	private int price;
	private int qty;

	public Product(int serial, String name, int price, int qty) {
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format(" %-10s\t|", this.getSerial()));
		sb.append(String.format(" %-10s\t|", this.getName()));
		sb.append(String.format(" %-10s\t|", this.getPrice()));
		sb.append(String.format(" %-10s\t|", this.getQty()));

		return String.valueOf(sb);
	}
}