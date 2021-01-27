package com.ssafy.hw06.step3;

import java.util.Arrays;

public class ProductMgr {
	private int MAX_SIZE = 100;
	private Product[] prds = new Product[MAX_SIZE];
	private int size;

	public void add(Product prd) {
		if (MAX_SIZE > size) {
			prds[size] = prd;
			size++;
		}
	}

	public Product[] getList() {
		System.out.println("**************************상품 전체 목록***************************");
		Product[] results = null;
		int cnt = 0;

		for (Product prd : prds) {
			if (prd != null) {
				cnt++;
			} else {
				break;
			}
		}

		results = new Product[cnt];

		results = Arrays.copyOf(prds, cnt);

		return results;
	}

	public Product searchBySerial(int serial) {
		System.out.println("**********************상품번호 검색:" + serial + "***********************");
		Product result = null;

		for (Product prd : prds) {
			if (prd == null) {
				break;
			} else if (prd.getSerial() == serial) {
				result = prd;
				break;
			} else
				;
		}

		return result;
	}

	public Product[] searchByTitle(String name) {
		System.out.println("**********************상품명 포함검색:" + name + "***********************");
		int cnt = 0;
		Product[] results = null;

		for (Product prd : prds) {
			if (prd == null) {
				break;
			} else if (prd.getName().contains(name)) {
				cnt++;
			} else
				;
		}

		results = new Product[cnt];
		cnt = 0;

		for (Product prd : prds) {
			if (prd == null) {
				break;
			} else if (prd.getName().contains(name)) {
				results[cnt] = prd;
				cnt++;
			} else
				;
		}

		return results;
	}

	public Product[] getTV() {
		System.out.println("****************************TV 목록*****************************");
		int cnt = 0;
		Product[] results = null;

		for (Product prd : prds) {
			if (prd instanceof TV) {
				cnt++;
			} else if (prd == null) {
				break;
			} else
				;
		}

		results = new Product[cnt];
		cnt = 0;

		for (Product prd : prds) {
			if (prd instanceof TV) {
				results[cnt] = prd;
				cnt++;
			} else if (prd == null) {
				break;
			} else
				;
		}

		return results;
	}

	public Product[] getRefrigerator() {
		System.out.println("****************************냉장고 목록*****************************");
		int cnt = 0;
		Product[] results = null;

		for (Product prd : prds) {
			if (prd instanceof Refrigerator) {
				cnt++;
			} else if (prd == null) {
				break;
			} else
				;
		}

		results = new Product[cnt];
		cnt = 0;

		for (Product prd : prds) {
			if (prd instanceof Refrigerator) {
				results[cnt] = prd;
				cnt++;
			} else if (prd == null) {
				break;
			} else
				;
		}

		return results;
	}

	public boolean delete(int serial) {
		for (int i = 0; i < size; i++) {
			if (prds[i].getSerial() == serial) {
				prds[i] = prds[size - 1];
				prds[size - 1] = null;
				size--;
				return true;
			}
		}

		return false;
	}

	public int getTotalPrice() {
		int sum = 0;

		for (Product prd : prds) {
			if (prd == null) {
				break;
			} else {
				sum += (prd.getPrice() * prd.getQty());
			}
		}

		return sum;
	}

}