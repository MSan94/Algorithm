```
void hanoi_tower(int n, char from, char to, char temp){
  if(n == 1) {
    from에서 to로 원판 이동
    System.out.println(" 원판 1을 " + from " + " -> " + to );
  }
  else {
    Step1 ) from의 맨 밑에 원판을 제외한 나머지 원판들을 temp로 이동
    hanoi_tower(n-1, from, to , temp);
    
    Step2 ) from에 있는 한 개의 원판을 to로 이동
    System.out.println(" 원판 " + n + "을 " + from + " -> " + to );
    
    Step3 ) temp의 원판들을 to로 이동
    hanoi_tower(n-1, temp, from, to);
  }
}
```
