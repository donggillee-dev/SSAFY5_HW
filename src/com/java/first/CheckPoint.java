package com.java.first;

import java.io.*;
import java.util.StringTokenizer;

public class CheckPoint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(stk.nextToken());
		int weight = Integer.parseInt(stk.nextToken());
		int point = weight + 100 - height;
		
		sb.append("비만수치는 ").append(point).append("입니다.").append("\n");
		
		if(point > 0) {
			sb.append("당신은 비만이군요.").append("\n");
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
}
