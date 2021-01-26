package com.ssafy.ws03.step3;

public class ProductTest {
	public static void main(String[] args) {
		TV samTv = new TV("12345", "QLED", 1000000, 5, 55.0, "QLED");
		Refrigerator samRf = new Refrigerator("22342", "HUB", 1500000, 3, 800); 
		
		samTv.setQty(10);
		samRf.setQty(20);
		
		
		System.out.println(samTv.toString());
		System.out.println(samRf.toString());
	}
}
