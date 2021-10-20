# DFS
- 재귀
```
static void dfs(int start){
  visited[start] = true;
  System.out.print(start + " ");
  for(int node : arr[start]){
    if(!visited[node]){
      dfs(node);
    }
  }
}
```
- stack
```
static void dfs(int start){
  Stack<Integer> stack = new Stack<>();
  stack.push(start);
  visited[start] = true;
  System.out.print(next + " ");
  while(!stack.isEmpty()){
    for(int i=1; i<=N; i++){
      if(arr[start][i] == 1 && visited[i] == false){
        stack.push(i);
        visited[i] = true;
        dfs(i);
      }
    }
    stack.pop();
  }
}
```
# BFS
```
static void bfs(int start){
  Queue<Integer> q = new LinkedList<>();
  visited[start] = true;
  q.offer(start);
  while(!q.isEmpty()){
    int next = q.poll();
    System.out.print(next + " ");
    for(int i=1; i<=N; i++){
      if(arr[next][i] == 1 && visited[i] == false){
        visited[i] = true;
        q.offer(i);
      }
    }
  }
}
```

# 이진탐색
```
static void binary(int key, int arr[]){
  int mid;
  int left = 0;
  int right = arr.length - 1;
  while(right >= left){
    mid = (right + left) / 2;
    if(key == arr[mid]){
      System.out.println(mid);
      break;
    }
    
    if(key < arr[mid]){
      right = mid - 1;
    }else{
      left = mid + 1;
  }
}
```
