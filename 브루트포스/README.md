# Q14888
```
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q14888 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, max, min;
	static int[] nums, operators, order;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
//		input();
//		rec_func(1);
//		sb.append(max).append('\n').append(min);
//		System.out.println(sb.toString());
		int n = 45;
		String answer = "";
		
		while(n >= 3) {
			answer += n % 3;
			System.out.println(answer);
			n /= 3;
		}
		answer += n;
		System.out.println(answer);
		System.out.println(Integer.parseInt("0021", 3));
	}
	
	static void input() throws Exception{
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		operators = new int[5];
		order = new int[N+1];
		for(int i=1; i<=N; i++) nums[i] = Integer.parseInt(br.readLine());
		for(int i=1; i<=4; i++) operators[i] = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
	
	// order[1...N-1] 에 연산자들이 순서대로 저장
	static void rec_func(int k) {
		if(k == N) {
			// 완성된 식에 맞게 계산하여 갱신 작업
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		}else {
			// k번째 연산자는 무엇을 선택?
			for(int cand = 1; cand <= 4; cand++) {
				if(operators[cand] >= 1) {
					operators[cand]--;
					order[k] = cand;
					rec_func(k+1);
					operators[cand]++;
					order[k] = 0;
				}
			}
		}
	}
	
	// 완성된 식에 맞게 계산하여 갱신 작업
	static int calculator() {
		//nums, order
		int value = nums[1];
		for(int i=1; i<N-1; i++) {
			// value, order[i], nums[i+1]
			if(order[i] == 1) // +
				value = value +  nums[i+1];
			if(order[i] == 2) // -
				value = value +  nums[i+1];
			if(order[i] == 3) // *
				value = value +  nums[i+1];
			if(order[i] == 4) // /
				value = value +  nums[i+1];
		}
		return value;
	}
}

```
