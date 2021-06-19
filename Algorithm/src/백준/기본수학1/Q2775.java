package ����.�⺻����1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2775 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[15][15];
		for (int i = 0; i < 15; i++) {
			arr[i][1] = 1; // i�� 1ȣ
			arr[0][i] = i; // 0�� iȣ
		}
 
		for (int i = 1; i < 15; i++) { // 1������ 14������
 
			for (int j = 2; j < 15; j++) { // 2ȣ���� 14ȣ����
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			int floor = Integer.parseInt(br.readLine());
			int ho = Integer.parseInt(br.readLine());
			sb.append(arr[floor][ho]).append('\n');
		}
		System.out.println(sb.toString());
		
		
	}
}
