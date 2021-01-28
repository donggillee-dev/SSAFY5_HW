package com.ssafy.ws07.step3;

import java.util.ArrayList;

//도서리스트를 관리하기 위한 인터페이스
public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	ArrayList<Book> getList();
	Book searchByIsbn(String isbn);
	ArrayList<Book> searchByTitle(String title);
	ArrayList<Magazine> getMagazines();
	ArrayList<Book> getBooks();
	int getTotalPrice();
	double getPriceAvg();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
}