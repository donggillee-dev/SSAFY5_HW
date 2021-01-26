package com.ssafy.ws05.step3;

public class ProductMgr {
	private static ProductMgr manager;
	private int MAX_SIZE = 100;
	private Product[] products = new Product[MAX_SIZE];
	private int size = 0;
	
	public static ProductMgr getInstance() {
		if(manager==null) {
			manager = new ProductMgr();
		}
		return manager;
	}
	
	public void add(Product p) {
		products[size] = p;
		size++;
	}
	
	public Product[] list() {
		System.out.println("***********************물품목록***********************");
		return products;
	}
	
	public Product list(int num) {
		boolean flag = false;
		Product ret = null;
		
		System.out.println("***********************물품검색:" + num + "***********************");
		for(Product p : products) {
			if(p != null && p.getSerial() == num) {
				flag = true;
				ret = p;
				System.out.println(p);
				break;
			}
		}
		if(!flag) {
			System.out.println("***********************해당 물품이 없습니다***********************");
		}
		
		System.out.println();
		return ret;
	}
	
	public void delete(int num) {
		System.out.println("***********************물품삭제:" + num + "***********************");
		int pivot = 0;
		boolean flag = false;
		
		for(int i = 0; i < size; i++) {
			if(products[i].getSerial() == num) {
				products[i] = null;
				flag = true;
				pivot = i;
				break;
			}
		}
		
		if(flag) {
			products[pivot] = products[size - 1];
			products[size - 1] = null;
			size--;
		} else {
			System.out.println("***********************해당 물품이 없습니다***********************");
		}
		System.out.println();
		
	}
	
	public Product[] priceList(int price) {
		boolean flag = false;
		int cnt = 0;
		System.out.println("***********************가격이 " + price + "원 이하인 상품들***********************");
		for(Product p : products) {
			if(p != null && p.getPrice() <= price) {
				cnt++;
				flag = true;
			}
		}
		
		Product[] ret = new Product[cnt];
		if(!flag) {
			System.out.println("***********************해당 물품이 없습니다***********************");
		} else {
			int i = 0;
			for(Product p : products) {
				if(p != null && p.getPrice() <= price) {
					ret[i] = p;
					i++;
				}
			}
		}
		return ret;
	}
}
