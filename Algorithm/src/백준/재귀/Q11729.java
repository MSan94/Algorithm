package ����.���;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q11729 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
	public static void main(String[] args) throws IOException {
		Scanner scanner=new Scanner(System.in);
		int num; //���� ���� 
		num=scanner.nextInt(); 
		hanoi(1,2,3,num);

	}
 
	/*
		N : ������ ���� 
		start : ����� 
		mid : �ű�� ���� �̵��ؾ� ��� 
		to : ������
	 */
 
	public static void hanoi(int from,int m,int to,int num){
		if(num==0)
			return; 
		hanoi(from,to,m,num-1); 
		System.out.printf("%d : %d -> %d\n",num,from,to);
		hanoi(m,from,to,num-1);
	}
}
