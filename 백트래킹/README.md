# N-QUEEN
```
/*
 
  back_tracking(3) -> level 0,1,2는 모두 조건을 만족하게 퀸을 놓았고 현재는 4번째 열에 머물러 있다.
  
  
 */
class N_Queens{
	private int N;
	private int cols[];
	public N_Queens(int N) {
		this.N = N;
		cols = new int[N];
	}
	
	public void back_tracking(int level) {
		// level : 현재의 따질 행의 위치
		if(level == N) {
			// 현재 따질 위치가 N열인지?
			// N-1 까지 행이 있는데 N열까지 왔다는건 N-1까지 모두 조건을 만족한다는 얘기므로 출력
			for(int i=0; i<N; i++) {
				System.out.print(cols[i]);
			}
			System.out.println();
		}else {
			// 현재 상황에 level - 1 까지는 모두 조건대로 되어있고 level열에 퀸을 놓는 상황
			for(int i=0; i<N; i++) { //퀸틀 0부터 N-1까지 놓는 경우를 전부 따져봄
				cols[level] = i; //퀸틀 i에 놓는다
				if(isPossible(level)) { //퀸을 i에 놓는것이 가능한지
					back_tracking(level+1); // 그렇다면 퀸을 그 자리에 넣고 다음 행으로 진입
				}
			}
		}
	}
	
	public boolean isPossible(int level) {
		for(int i=0; i<level; i++) {
			// level 위치에 현재 시험할 퀸이 놓여져 있는 상태고, 우리는 그 퀸과 i = 0 ~ level-1에 놓여있는 퀸이 문제를 일으키는지만 보면 된다.
			if(cols[i]==cols[level] || Math.abs(level-i) == Math.abs(cols[level]-cols[i])) {
				// i번째 퀸의 위치와 level 위치의 퀸이 같은 일직선상에 있는경우
				// 또는 
				// i번째 퀸의 위치와 level 위치의 퀸이 대각선상에 있는 경우.
				// 밑변과 높이가 같으면 대각선상에 있다고 볼 수 있다.
				return false; // 이 경우는 불가능 하므로 false 리턴
			}
		}
		return true;
	}
}

public class 백트래킹 {
	public static void main(String[] args) {
		N_Queens q = new N_Queens(4);
		q.back_tracking(0);
	}
}


```
