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
