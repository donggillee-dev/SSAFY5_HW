package com.ssafy.ws03.step3;

public class TV {
	private String prdNum;
	private String prdName;
	private int price;
	private int qty;
	private double inch;
	private String type;
	
	public TV(String prdNum, String prdName, int price, int qty, double inch, String type) {
		super();
		this.prdNum = prdNum;
		this.prdName = prdName;
		this.price = price;
		this.qty = qty;
		this.inch = inch;
		this.type = type;
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


	public double getInch() {
		return inch;
	}


	public void setInch(double inch) {
		this.inch = inch;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "TV [prdNum=" + prdNum + ", prdName=" + prdName + ", price=" + price + ", qty=" + qty + ", inch=" + inch
				+ ", type=" + type + "]";
	}
	
}
