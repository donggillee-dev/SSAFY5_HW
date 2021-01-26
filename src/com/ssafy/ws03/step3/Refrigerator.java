package com.ssafy.ws03.step3;

public class Refrigerator {
	private String prdNum;
	private String prdName;
	private int price;
	private int qty;
	private int liter;
	
	public Refrigerator(String prdNum, String prdName, int price, int qty, int liter) {
		super();
		this.prdNum = prdNum;
		this.prdName = prdName;
		this.price = price;
		this.qty = qty;
		this.liter = liter;
	}

	public String getPrdNum() {
		return prdNum;
	}

	public void setPrdNum(String prdNum) {
		this.prdNum = prdNum;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
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

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	@Override
	public String toString() {
		return "Refrigerator [prdNum=" + prdNum + ", prdName=" + prdName + ", price=" + price + ", qty=" + qty
				+ ", liter=" + liter + "]";
	}
	
}
