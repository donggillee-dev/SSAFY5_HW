package com.ssafy.ws02.step3;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("/Users/giri/SSAFY/eclipse-workspace/javawork/JavaProject/src/com/ssafy/ws02/step3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 방량 Array 생성(대각 포함)
		int[] dir_x = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dir_y = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// T 입력
		int T = Integer.parseInt(br.readLine());

		// 테스트케이스 loop
		for (int tc = 0; tc < T; tc++) {
			// N 입력, area배열, height배열 생성
			int N = Integer.parseInt(br.readLine());
			char[][] area = new char[N][N];
			int[][] height = new int[N][N];
			int max = Integer.MIN_VALUE;

			// Area 배열 init
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < tmp.length(); j++) {
					area[i][j] = tmp.charAt(j);
				}
			}

			// 공원조성단지 주변 빌딩 2로 세팅
			for (int i = 0; i < area.length; i++) {
				for (int j = 0; j < area[i].length; j++) {
					if (area[i][j] == 'B') {
						for (int k = 0; k < dir_x.length; k++) {
							int nx = i + dir_x[k];
							int ny = j + dir_y[k];

							if (nx < 0 || ny < 0 || nx >= N || ny >= N)
								continue;
							if (area[nx][ny] == 'G') {
								height[i][j] = 2;
								break;
							}
						}
					}
				}
			}

			// 공원조성단지와 인접하지 않은 빌딩 구역 높이 도출
			for (int i = 0; i < area.length; i++) {
				for (int j = 0; j < area[i].length; j++) {
					if (area[i][j] == 'B' && height[i][j] == 0) {
						//상
						for(int idx = i-1; idx >= 0; idx--) {
							if(area[idx][j] == 'B') {
								height[i][j]++;
							}
						}
						//하
						for(int idx = i+1; idx < N; idx++) {
							if(area[idx][j] == 'B') {
								height[i][j]++;
							}
						}
						//좌
						for(int idx = j-1; idx >= 0; idx--) {
							if(area[i][idx] == 'B') {
								height[i][j]++;
							}
						}
						//우
						for(int idx = j+1; idx < N; idx++) {
							if(area[i][idx] == 'B') {
								height[i][j]++;
							}
						}
						height[i][j]++;
					}
				}
			}
			
			//가장 높은 빌딩을 도출해냄
			for(int i = 0; i < height.length; i++) {
				for(int j = 0; j < height[i].length; j++) {
					if(max < height[i][j]) max = height[i][j];
				}
			}
			sb.append("#" + (tc + 1)).append(" " + max).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}

}
