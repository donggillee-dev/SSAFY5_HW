package com.ssafy.hw08.step3;

public class DuplicateException extends Exception {
	public DuplicateException(int serial) {
		super("시리얼번호 : " + serial + "인 해당 상품은 이미 존재합니다!!");
	}
}
