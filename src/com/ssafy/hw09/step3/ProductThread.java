package com.ssafy.hw09.step3;

import java.io.*;
import java.util.HashMap;

public class ProductThread extends Thread {
	private HashMap<Integer, Product> obj;
	public ProductThread(HashMap<Integer, Product> obj) {
		this.obj = obj;
	}

	public void run() {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("product.dat"))){
			oos.writeObject(obj);
			oos.close();
			System.out.println("[SYSTEM] 파일 저장 완료");
		} catch (IOException e) {
			System.out.println("[SYSTEM] 파일 저장 실패");
		}
		obj = null;
	}
}
