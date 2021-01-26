package com.ssafy.ws05.step3;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductMgr pm = ProductMgr.getInstance();
		
		pm.add(new Product(123123, "test1", 15000, 30));
		pm.add(new Product(111111, "test2", 25000, 20));
		pm.add(new Product(222222, "test3", 30000, 10));
		
		for(Product prd : pm.list()) {
			if(prd == null) break;
			System.out.println(prd);
		}
		
		pm.list(123123);
		
		pm.delete(123123);
//		
		for(Product prd : pm.priceList(25000) ) {
			if(prd != null)
				System.out.println(prd);
		}
		
	}

}
