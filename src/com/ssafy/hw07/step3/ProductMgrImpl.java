package com.ssafy.hw07.step3;

import java.util.Arrays;
import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
	private ArrayList<Product> prds = new ArrayList<>();
	private int size; // 

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
	public void add(Product prd) {
		// TODO Auto-generated method stub
		prds.add(prd);
		size++;
		
	}

	@Override
	public Product[] getList() {
		// TODO Auto-generated method stub
		System.out.println("**************************상품 전체 목록***************************");
		Product[] results = prds.toArray(new Product[prds.size()]);
		
		return results;
	}

	@Override
	public Product searchBySerial(int serial) {
		// TODO Auto-generated method stub
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

	@Override
	public Product[] searchByTitle(String name) {
		// TODO Auto-generated method stub
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

	@Override
	public Product[] getTv() {
		// TODO Auto-generated method stub
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

	@Override
	public Product[] getRefrigerator() {
		// TODO Auto-generated method stub
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

	@Override
	public Product[] getRefrigOver() {
		// TODO Auto-generated method stub
		System.out.println("****************************400L 이상 냉장고 목록*****************************");
		int liter = 400;
		int cnt = 0;
		Product[] results = null;

		for (int i = 0; i < size; i++) {
			if (prds.get(i) instanceof Refrigerator && ((Refrigerator) prds.get(i)).getLiter() >= liter) {
				cnt++;
			}
		}

		if (cnt != 0) {
			results = new Product[cnt];
			cnt = 0;

			for (int i = 0; i < size; i++) {
				if (prds.get(i) instanceof Refrigerator && ((Refrigerator) prds.get(i)).getLiter() >= liter) {
					results[cnt] = prds.get(i);
					cnt++;
				}
			}
		}

		return results;
	}

	@Override
	public Product[] getTvOver() {
		System.out.println("****************************50inch 이상 TV 목록*****************************");
		// TODO Auto-generated method stub
		int inch = 50;
		int cnt = 0;
		Product[] results = null;

		for (int i = 0; i < size; i++) {
			if (prds.get(i) instanceof TV && ((TV) prds.get(i)).getInch() >= inch) {
				cnt++;
			}
		}

		if (cnt != 0) {
			results = new Product[cnt];
			cnt = 0;

			for (int i = 0; i < size; i++) {
				if (prds.get(i) instanceof TV && ((TV) prds.get(i)).getInch() >= inch) {
					results[cnt] = prds.get(i);
					cnt++;
				}
			}
		}

		return results;
	}

	@Override
	public boolean update(int serial, int price) {
		System.out.println("****************************상품 업데이트*****************************");
		// TODO Auto-generated method stub
		boolean result = false;
		for (int i = 0; i < size; i++) {
			if (prds.get(i).getSerial() == serial) {
				prds.get(i).setPrice(price);
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean delete(int serial) {
		System.out.println("****************************상품 삭제*****************************");
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			if (prds.get(i).getSerial() == serial) {
				prds.remove(i);
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
