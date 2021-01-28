package com.ssafy.hw08.step3;

public class ProductNotFoundException extends Exception{
	public ProductNotFoundException() {
		super("400L 이상인 냉장고가 없습니다");	
	}
	public ProductNotFoundException(String cond) {
		super("50inch 이상인 TV가 없습니다");
	}
}
