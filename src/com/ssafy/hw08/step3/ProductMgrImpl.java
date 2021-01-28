package com.ssafy.hw08.step3;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductMgrImpl implements IProductMgr {
	private HashMap<Integer, Product> prds = new HashMap<>();
	private int size = 0; //

	// 싱글톤 디자인패턴 위해 유지하는 객체 참조값 -------------------------------------------
	// 클래스 메모리에 로드시에 객체 1번 생성하여 참조값 유지
	private static IProductMgr instance = new ProductMgrImpl();

	// 외부에서 객체 생성을 하지 못하도록 접근 제어자를 private으로 만든 생성자--------------------
	private ProductMgrImpl() {
		super();
	}

	public static IProductMgr getInstance() {
		return instance;
	}

	@Override
	public void add(Product prd) throws DuplicateException {
		// TODO Auto-generated method stub
		if (prds.containsKey(prd.getSerial())) {
			throw new DuplicateException(prd.getSerial());
		} else {
			prds.put(prd.getSerial(), prd);
			size++;
		}

	}

	@Override
	public ArrayList<Product> getList() {
		// TODO Auto-generated method stub
		System.out.println("**************************상품 전체 목록***************************");

		ArrayList<Product> result = new ArrayList<Product>(prds.values());

		return result;
	}

	@Override
	public Product searchBySerial(int serial) throws CodeNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("**********************상품번호 검색:" + serial + "***********************");
		Product result = null;

		for (Product prd : prds.values()) {
			if (prd.getSerial() == serial) {
				result = prd;
				break;
			}
		}

		if (result == null) {
			throw new CodeNotFoundException(serial);
		}

		return result;
	}

	@Override
	public ArrayList<Product> searchByTitle(String name) {
		// TODO Auto-generated method stub
		System.out.println("**********************상품명 포함검색:" + name + "***********************");
		ArrayList<Product> result = new ArrayList<>();

		for (Product prd : prds.values()) {
			if (prd.getName().contains(name)) {
				result.add(prd);
			} else
				;
		}

		if (result.size() == 0) {
			System.err.println("해당 상품 없습니다");
		}
		return result;
	}

	@Override
	public ArrayList<Product> getTv() {
		// TODO Auto-generated method stub
		System.out.println("****************************TV 목록*****************************");
		ArrayList<Product> result = new ArrayList<>();

		for (Product prd : prds.values()) {
			if (prd instanceof TV) {
				result.add(prd);
			} else
				;
		}

		if (result.size() == 0) {
			System.err.println("TV 상품 목록이 없습니다");
		}

		return result;
	}

	@Override
	public ArrayList<Product> getRefrigerator() {
		// TODO Auto-generated method stub
		System.out.println("****************************냉장고 목록*****************************");
		ArrayList<Product> result = new ArrayList<>();

		for (Product prd : prds.values()) {
			if (prd instanceof Refrigerator) {
				result.add(prd);
			} else
				;
		}

		if (result.size() == 0) {
			System.err.println("TV 상품 목록이 없습니다");
		}

		return result;
	}

	@Override
	public ArrayList<Product> getRefrigOver() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("****************************400L 이상 냉장고 목록*****************************");
		int liter = 400;
		ArrayList<Product> result = new ArrayList<>();

		for (Product prd : prds.values()) {
			if (prd instanceof Refrigerator && ((Refrigerator) prd).getLiter() >= liter) {
				result.add(prd);
			}
		}

		if (result.size() == 0) {
			throw new ProductNotFoundException();
		}

		return result;
	}

	@Override
	public ArrayList<Product> getTvOver() throws ProductNotFoundException {
		System.out.println("****************************50inch 이상 TV 목록*****************************");
		// TODO Auto-generated method stub
		int liter = 400;
		ArrayList<Product> result = new ArrayList<>();

		for (Product prd : prds.values()) {
			if (prd instanceof Refrigerator && ((Refrigerator) prd).getLiter() >= liter) {
				result.add(prd);
			}
		}

		if (result.size() == 0) {
			throw new ProductNotFoundException("TV Exception");
		}

		return result;
	}

	@Override
	public boolean update(int serial, int price) {
		System.out.println("****************************상품 업데이트*****************************");
		// TODO Auto-generated method stub

		for (Product prd : prds.values()) {
			if (prd.getSerial() == serial) {
				prd.setPrice(price);
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean delete(int serial) {
		System.out.println("****************************상품 삭제*****************************");
		// TODO Auto-generated method stub

		for (Product prd : prds.values()) {
			if (prd.getSerial() == serial) {
				prds.remove(serial);
				size--;
				return true;
			}
		}

		return false;
	}

	@Override
	public int getTotalPrice() {
		System.out.println("****************************상품 가격 총합*****************************");
		// TODO Auto-generated method stub
		int sum = 0;

		for (Product prd : prds.values()) {

			sum += (prd.getPrice() * prd.getQty());

		}

		return sum;
	}

}
