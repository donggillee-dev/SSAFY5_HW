package com.java.first;

import java.io.*;
import java.util.StringTokenizer;

public class Compute {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		
		sb.append("곱=").append(a * b).append("\n");
		sb.append("몫=").append(a / b).append("\n");
		
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
}
