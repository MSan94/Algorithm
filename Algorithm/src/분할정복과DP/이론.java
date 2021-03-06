package 분할정복과DP;

/* 
동적계획법
- 입력 크기가 작은 부분 문제들을 해결한 후 해당 부분 문제의 해를 활용하여 보다 큰 크기의 부분 문제를 해결
- 최종적으로 전체 문제를 해결하는 알고리즘
- 상향식 접근법으로, 가장 최하위 해답을 구한 후, 이를 저장하고, 해당 결과값을 이용해서 상위 문제를 풀어가는 방식
- Memoization 기법 사용
	- 프로그램 실행 시 이전에 계산한 값을 저장하여, 다시 계산하지 않도록 하여 전체 실행 속도를 빠르게 하는 기술
	- 문제를 잘게 쪼갤 때, 부분 문제는 중복되어 재활용 ex) 피보나치

분할정복
- 문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 갑을 얻는 아록리즘
- 하양식 접근법으로, 상위의 해답을 구하기 위해, 아래로 내려가면서 하위의 해답을 구하는 방식
	- 일반적으로 재귀함수로 구현
- 문제를 잘게 쪼갤 때, 부분 문제는 서로 중복되지 않음
	- ex) 병합정렬, 퀵 정렬

공통점
- 큰 문제를 잘게 쪼개서, 작은 단위로 분할

차이점
- 동적
	- 부분 문제 중복o, 상위 문제 해결 시 재활용 -> Memoization
- 분할
	- 부분 문제 중복x, Memoization 사용 x 

*/