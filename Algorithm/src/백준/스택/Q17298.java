package ����.����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17298 {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] stack = new int[N];	// ����ó�� �� �迭 
		int top = -1;	// ������ �� �� ���Ҹ� ����Ű�� ����
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
 
		for (int i = 0; i < N; i++) {
			/*
			 * ������ ������� �����鼭 (= top �� -1�� �ƴ� ���) 
			 * ���� ���Ұ� ������ �� �� ���Ұ� ����Ű�� ���Һ��� ū ���
			 * �ش� ������ ������ �� ���� stack�� ���Ҹ� pop�ϸ鼭
			 * �ش� �ε����� ���� ���� ���ҷ� �ٲ��ش�. 
			 */
			while (top != - 1 && seq[stack[top]] < seq[i]) {
				seq[stack[top]] = seq[i];
				top--;
			}
			top++;
			stack[top] = i;
		}
 
		/*
		 * ������ ��� ���Ҹ� pop�ϸ鼭 �ش� �ε����� value��
		 * -1�� �ʱ�ȭ�Ѵ�.
		 */
		for(int i = top; i >= 0; i--) {
			seq[stack[i]] = -1;
		}
 
		StringBuilder sb = new StringBuilder();
		for (int v : seq) {
			sb.append(v).append(' ');
		}
 
		System.out.println(sb);
	}
}
