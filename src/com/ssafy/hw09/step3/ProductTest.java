package com.ssafy.hw09.step3;

public class ProductTest implements Runnable{
	private static IProductMgr pm;

	public ProductTest() {
		super();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		pm.save();
	}
	public static void main(String[] args) {
		pm = ProductMgrImpl.getInstance();
		pm.load();
		
		try {
			pm.add(new TV(12345, "STV1", 12345, 2, 40.5, "tv1"));	
		} catch(DuplicateException e) {
			System.err.println(e.getMessage());
		}
		try {
			pm.add(new TV(11111, "STV2", 12323, 3, 33.5, "tv2"));	
		} catch(DuplicateException e) {
			System.err.println(e.getMessage());
		}
		try {
			pm.add(new TV(22222, "STV3", 12235, 1, 44.5, "tv3"));	
		} catch(DuplicateException e) {
			System.err.println(e.getMessage());
		}
		try {
			pm.add(new TV(33333, "STV4", 12113, 4, 11.5, "tv4"));	
		} catch(DuplicateException e) {
			System.err.println(e.getMessage());
		}
		try {
			pm.add(new Refrigerator(44444, "RF1", 18283, 5, 100));	
		} catch(DuplicateException e) {
			System.err.println(e.getMessage());
		}
		try {
			pm.add(new Refrigerator(55555, "RF2", 18299, 1, 110));	
		} catch(DuplicateException e) {
			System.err.println(e.getMessage());
		}
		try {
			pm.add(new Refrigerator(66666, "RF3", 14983, 2, 120));	
		} catch(DuplicateException e) {
			System.err.println(e.getMessage());
		}
		try {
			pm.add(new Refrigerator(77777, "RF4", 18683, 7, 140));		
		} catch(DuplicateException e) {
			System.err.println(e.getMessage());
		}
		
			
		for (Product prd : pm.getList()) {
			System.out.println(prd);
		}

		try {
			System.out.println(pm.searchBySerial(12345));	
		} catch(CodeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(pm.searchBySerial(1239218));	
		} catch(CodeNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for (Product prd : pm.searchByTitle("STV")) {
			System.out.println(prd);
		}

		for (Product prd : pm.getTv()) {
			System.out.println(prd);
		}

		for (Product prd : pm.getRefrigerator()) {
			System.out.println(prd);
		}

		try {
			for(Product prd : pm.getRefrigOver()) {
				System.out.println(prd);
			}
		} catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			for(Product prd : pm.getTvOver()) {
				System.out.println(prd);
			}
		} catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		

		if (pm.update(11111, 99999)) {
			System.out.println("시리얼 번호 : 11111 상품이 제대로 업데이트되었습니다");
			for(Product prd : pm.getList()) {
				System.out.println(prd);
			}
		} else {
			System.err.println("시리얼 번호 : 11111 상품이 없습니다!");
		}

		System.out.println(pm.getTotalPrice());

		if (pm.delete(12345)) {
			System.out.println("시리얼 번호 : 12345 상품이 제대로 삭제되었습니다");
		} else {
			System.err.println("시리얼 번호 : 12345 상품이 없습니다!");
		}

		for (Product prd : pm.getList()) {
			System.out.println(prd);
		}

		Thread t = new Thread(new ProductTest());
		t.start();
		try {
			t.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
