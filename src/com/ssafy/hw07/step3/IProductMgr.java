package com.ssafy.hw07.step3;

public interface IProductMgr {
	public void add(Product prd);
	public Product[] getList();
	public Product searchBySerial(int serial);
	public Product[] searchByTitle(String name);
	public Product[] getTv();
	public Product[] getRefrigerator();
	public Product[] getRefrigOver();
	public Product[] getTvOver();
	public boolean update(int serial, int price);
	public boolean delete(int serial);
	public int getTotalPrice();
}
