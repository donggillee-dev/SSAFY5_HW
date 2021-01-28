package com.ssafy.hw08.step3;

public class CodeNotFoundException extends Exception {
	public CodeNotFoundException(int serial) {
		super("일련번호 : "+ serial + " 상품은 존재하지 않습니다..");
	}
}
