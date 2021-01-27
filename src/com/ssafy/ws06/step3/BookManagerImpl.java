package com.ssafy.ws06.step3;

import java.util.Arrays;

//도서리스트를 배열로 유지하며 관리하는 클래스
public class BookManagerImpl implements IBookManager {
	private static int MAX_SIZE = 100;  //관리할 최대 도서 수
	private Book[] books = new Book[MAX_SIZE]; //관리할 도서 리스트
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
		if(size<MAX_SIZE) books[size++] = book;
	}
	//고유번호로 해당 도서를 도서리스트에서 삭제한다.------------------------------------------
	@Override
	public void remove(String isbn) {
		for (int i = 0; i < size; ++i) {
			// 삭제할 도서를 찾았다면 해당 도서 위치에 배열의 제일 마지막 도서를 복사
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[size-1];
				books[size-1]=null;			// 삭제된 도서 위치 null 처리
				--size;						// 등록된 도서 수 감소
				break;
			}
		}
	}
	//등록된 도서리스트를 반환한다------------------------------------------------------
	@Override
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	//고유번호로 해당 도서를 조회한다.----------------------------------------------------
	@Override
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; ++i) {
			if (books[i].getIsbn().equals(isbn)) return books[i]; 
		}
		return null;
	}
	//도서 제목을 포함하고 있는 도서리스트를 반환한다.-----------------------------------------
	@Override
	public Book[] searchByTitle(String title) {
		int count = 0; 
		for (int i = 0; i < size; ++i) {
			if (books[i].getTitle().contains(title)) ++count;
		}
		
		Book[] result = new Book[count];
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (books[i].getTitle().contains(title)) {
				result[idx++] = books[i];
			}
		}
		return result; 
	}
	//잡지리스트를 반환한다.---------------------------------------------------------
	@Override
	public Magazine[] getMagazines() {
		int count = 0;
		for (int i = 0; i < size; ++i) {
			if (books[i] instanceof Magazine) ++count;
		}
		
		Magazine[] result = new Magazine[count];
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (books[i] instanceof Magazine) {
				result[idx++] = (Magazine)books[i];
			}
		}
		return result;
	} 
	//잡지가 아닌 도서리스트를 반환한다.-------------------------------------------------
	@Override
	public Book[] getBooks() {
		int count = 0; 
		for (int i = 0; i < size; ++i) {
			if (!(books[i] instanceof Magazine)) ++count;
		}
		
		Book[] result = new Book[count];
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (!(books[i] instanceof Magazine)) {
				result[idx++] = books[i];
			}
		}
		return result;
	}	
	//도서리스트의 가격의 총합을 반환한다.----------------------------------------------
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; ++i) {
			total += books[i].getPrice();
		}
		return total;
	}
	//도서가격의 평균을 반환한다.----------------------------------------------------
	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/ size;
	}
}
