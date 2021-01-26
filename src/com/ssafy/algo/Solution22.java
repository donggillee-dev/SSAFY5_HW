package com.ssafy.algo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution22 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("/Users/giri/SSAFY/eclipse-workspace/javawork/JavaProject/src/com/ssafy/algo/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//상, 하, 좌, 우
		int[] dir_row = {-1, 1, 0, 0};
		int[] dir_col = {0, 0, -1, 1};
		
		//TestCase 개수입력
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			//소금쟁이 수와 연못의 크기 입력
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			int[][] pool = new int[N][N];
			int result = C;
			
			//C개의 소금쟁이의 정보를 하나씩 받음
			for(int cnt = 0; cnt < C; cnt++) {
				stk = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(stk.nextToken());
				int col = Integer.parseInt(stk.nextToken());
				int dir = Integer.parseInt(stk.nextToken()) - 1;

				//시작위치에 이미 도착해서 안착한 소금쟁이가 있다면 사망처리
				if(pool[row][col] == 1) {
					result--;
				} else {
					//입력받은 소금쟁이 순으로 3 > 2 > 1 
					for(int width = 3; width > 0; width--) {
						
						row += (dir_row[dir] * width);
						col += (dir_col[dir] * width);
						
						//연못을 넘어가거나 이미 다 뛴 소금쟁이와 부딪히면 해당 소금쟁이 사망
						if(row < 0 || col < 0 || row >= N || col >= N || pool[row][col] == 1) {
							result--;
							break;
						} 
						
						//소금쟁이 도착시 연못배열에 1추가
						if(width == 1) {
							pool[row][col] = 1;
						}
					}	
				}
				
			}
			sb.append("#" + (tc + 1) + " " + result).append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}

}
