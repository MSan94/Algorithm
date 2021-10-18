# 정의
- 동적계획법 ( DP )
  - 입력 크기가 작은 부분 문제들을 해결한 후, 해당 부분 문제의 해를 활용해서, 보다 큰 크기의 부분 문제를 해결
  - 최종적으로 전체 문제를 해결하는 알고리즘
  - 상향식 접근으로, 가장 최하위 해답을 구한 후, 이를 저장하고, 해당 결과값을 이용해서 상위 문제를 풀어가는 방식
  - Memoization 기법
    - 프로그램 실행 시 이전에 계산한 값을 저장하여, 다시 계산하지 않도록 하여 실행속도 상승
  - 문제를 잘게 쪼갤 때, 부분 문제는 중복되어 재활용

- 분할 정복
  - 문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘
  - 하양식 접근법으로, 상위의 해답을 구하기 위해, 아래로 내려가면서 하위의 해답을 구하는 방식
    - 일반적으로 재귀함수로 구현
  - 문제를 잘게 쪼갤 때, 부분 문제는 서로 중복되지 않음
    - 병합 정렬, 퀵 정렬


# 공통점과 차이점
- 공통점
  - 문제를 잘게 쪼개서, 가장 작으 단위로 분할
- 차이점
  - 동적 계획법
    - 부분 문제는 중복되어, 상위 문제 해결 시 재활용
    - Memoization 기법 사용 ( 부분 문제의 해답을 저장해서 재활용하는 최적화 기법으로 사용 )
  - 분할 정복
    - 부분 문제는 서로 중복되지 않음
    - Memoization 기법 사용 X


# 동적계획법 피보나치
```
package DP;

import java.util.Arrays;

public class 피보나치 {
	public static void main(String[] args) {
		int result = dynamic(10);
		System.out.println(result);
	}
	
	static int dynamic(int data) {
		Integer[] cache = new Integer[data + 1];
		cache[0] = 0;
		cache[1] = 1;
		for(int i=2; i<data+1; i++) {
			cache[i] = cache[i-1] + cache[i-2];
			System.out.println(Arrays.toString(cache));
		}
		return cache[data];
	}
}

/*
[0, 1, 1, null, null, null, null, null, null, null, null]
[0, 1, 1, 2, null, null, null, null, null, null, null]
[0, 1, 1, 2, 3, null, null, null, null, null, null]
[0, 1, 1, 2, 3, 5, null, null, null, null, null]
[0, 1, 1, 2, 3, 5, 8, null, null, null, null]
[0, 1, 1, 2, 3, 5, 8, 13, null, null, null]
[0, 1, 1, 2, 3, 5, 8, 13, 21, null, null]
[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, null]
[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
55
*/
```
