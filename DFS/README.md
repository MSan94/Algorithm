```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static int[][] map;
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, start, end;

	public static void main(String[] args) throws Exception {
		input();
		init();
		initGraph();
		dfs(1);
		System.out.println(sb.toString());
	}

	static void dfs(int point) {
		Stack<Integer> stack = new Stack<>();
		stack.push(point);
		visited[point] = true;
		sb.append(point).append(" ");
		while (!stack.isEmpty()) {
			for (int i = 1; i <= N; i++) {
				if (map[point][i] == 1 && visited[i] == false) { // 다음 정점과 연결되어 있고 아직 방문하지 않았다면
					stack.push(i);
					visited[i] = true;
					dfs(i);
				}
			}
			stack.pop();
		}
	}

	static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}

	static void init() {
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
	}

	static void initGraph() throws Exception {
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
	}
}

```

# 미로찾기
```
package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
	static int N,M;
	static int[][] graph;
	static BufferedReader br;
	static StringTokenizer st;
	static boolean visited[][];
	static int[] dx = {-1,1,0,0}; //x축 상하
	static int[] dy = {0,0,-1,1}; //y축 좌우
	
	
	public static void main(String[] args) throws Exception{
		init();
		sol(0,0);
		System.out.println(graph[N-1][M-1]);
	}
	static void init() throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		visited = new boolean[N][M];
		visited[0][0] = true;
	}
	static void sol(int x, int y) throws Exception{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				if(visited[nextX][nextY] || graph[nextX][nextY] == 0) {
					continue;
				}
				
				q.add(new int[] {nextX, nextY});
				graph[nextX][nextY] = graph[nowX][nowY] + 1;
				visited[nextX][nextY] = true;
			}
		}
	}
}

```


# Q10026
```
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10026 {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static String graph[][];
	static boolean visit[][];
	static boolean visit2[][];
	static int N;
	static int result = 0,result2 = 0;
	public static void main(String[] args) throws Exception{
		init();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j] == false) {
					sol(i,j);
					result++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j].equals("G"))
					graph[i][j] = "R";
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit2[i][j] == false) {
					sol2(i,j);
					result2++;
				}
			}
		}
		
		sb.append(result).append(" ").append(result2);
		System.out.println(sb.toString());
	}
	static void init() throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new String[N][N];
		visit = new boolean[N][N];
		visit2 = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				graph[i][j] = String.valueOf(str.charAt(j));
			}
		}
	}
	
	static void sol(int x, int y) throws Exception{
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if(visit[nextX][nextY] == false && graph[nextX][nextY].equals(graph[x][y])) {
					visit[nextX][nextY] = true;
					sol(nextX,nextY);
				}
			}
		}
	}
	
	
	static void sol2(int x , int y) throws Exception{
		visit2[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if(visit2[nextX][nextY] == false && graph[nextX][nextY].equals(graph[x][y])) {
					visit2[nextX][nextY] = true;
					sol2(nextX,nextY);
				}
			}
		}
	}
}

```
