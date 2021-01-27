package com.ssafy.hw06.step3;

public class TV extends Product {
	private double inch;
	private String type;

	public TV(int serial, String name, int price, int qty, double inch, String type) {
		super(serial, name, price, qty);
		this.inch = inch;
		this.type = type;
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

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append(String.format(" %-10s\t|", this.getInch()));
		sb.append(String.format(" %-10s\t|", this.getType()));

		return String.valueOf(sb);
	}
}
