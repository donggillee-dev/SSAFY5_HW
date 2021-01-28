package com.ssafy.ws07.step3;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

//도서리스트를 배열로 유지하며 관리하는 클래스
public class BookManagerImpl implements IBookManager {
	private static int MAX_SIZE = 100;  //관리할 최대 도서 수
	private ArrayList<Book> books = new ArrayList<>();//관리할 도서 리스트
	private int size; //현재 등록된 도서 수
	
	
	//싱글톤 디자인패턴 위해 유지하는 객체 참조값 -------------------------------------------
	//클래스 메모리에 로드시에 객체 1번 생성하여 참조값 유지
	private static IBookManager instance = new BookManagerImpl();

	// 외부에서 객체 생성을 하지 못하도록 접근 제어자를  private으로 만든 생성자--------------------
	private BookManagerImpl() { 
		super();
	}
	public static IBookManager getInstance() {
		return instance;
	}
	//도서를 도서리스트에 추가한다.-----------------------------------------------------
	@Override
	public void add(Book book) {
		if(size<MAX_SIZE) {
			books.add(book);
			size++;
		}
	}
	//고유번호로 해당 도서를 도서리스트에서 삭제한다.------------------------------------------
	@Override
	public void remove(String isbn) {
		for (int i = 0; i < size; ++i) {
			// 삭제할 도서를 찾았다면 해당 도서 위치에 배열의 제일 마지막 도서를 복사
			if(books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				size--;
				break;
			}
		}
	}
	//등록된 도서리스트를 반환한다------------------------------------------------------
	@Override
	public ArrayList<Book> getList() {
		return books;
	}
	//고유번호로 해당 도서를 조회한다.----------------------------------------------------
	@Override
	public Book searchByIsbn(String isbn) {
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}
	//도서 제목을 포함하고 있는 도서리스트를 반환한다.-----------------------------------------
	@Override
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> result = new ArrayList<>();
		for(Book book : books) {
			if(book.getTitle().contains(title)) {
				result.add(book);
			}
		}
		
		return result; 
	}
	//잡지리스트를 반환한다.---------------------------------------------------------
	@Override
	public ArrayList<Magazine> getMagazines() {
		ArrayList<Magazine> result = new ArrayList<Magazine>();
		for (Book book : books) {
			if (book instanceof Magazine) {
				result.add((Magazine)book);
			}
		}
		
		
		return result;
	} 
	//잡지가 아닌 도서리스트를 반환한다.-------------------------------------------------
	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> result = new ArrayList<Book>();
		
		for(Book book : books) {
			if(!(book instanceof Magazine)) {
				result.add(book);
			}
		}
		
		return result;
	}	
	//도서리스트의 가격의 총합을 반환한다.----------------------------------------------
	@Override
	public int getTotalPrice() {
		int total = 0;
		for(Book book : books) {
			total += book.getPrice();
		}
		return total;
	}
	//도서가격의 평균을 반환한다.----------------------------------------------------
	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/ size;
	}
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		// TODO Auto-generated method stub
		Book book = searchByIsbn(isbn);
		if(book == null) throw new ISBNNotFoundException(isbn);
		
		int res = book.getQuantity() - quantity;
		if(res <= 0) throw new QuantityException();
		
		book.setQuantity(res);
	}
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		// TODO Auto-generated method stub
		Book book = searchByIsbn(isbn);
		if(book == null) throw new ISBNNotFoundException(isbn);
		
		book.setQuantity(book.getQuantity() + quantity);
	}
}
