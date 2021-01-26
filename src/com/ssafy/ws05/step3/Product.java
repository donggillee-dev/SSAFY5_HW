package com.ssafy.ws05.step3;

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


//	public void setSerial(int serial) {
//		this.serial = serial;
//	}


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
		return String.format("%-10d\t| %-10s\t| %-10d\t | %-10d\t|", serial, name, price, qty);
	}
}
