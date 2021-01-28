package com.ssafy.hw08.step3;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product prd) throws DuplicateException;

	public ArrayList<Product> getList();

	public Product searchBySerial(int serial) throws CodeNotFoundException;

	public ArrayList<Product> searchByTitle(String name);

	public ArrayList<Product> getTv();

	public ArrayList<Product> getRefrigerator();

	public ArrayList<Product> getRefrigOver() throws ProductNotFoundException;

	public ArrayList<Product> getTvOver() throws ProductNotFoundException;

	public boolean update(int serial, int price);

	public boolean delete(int serial);

	public int getTotalPrice();
}
