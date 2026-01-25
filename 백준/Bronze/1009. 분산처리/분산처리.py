T = int(input())
for _ in range(T):
  a, b = map(int, input().split())
  ans = [ a % 10 ]
  for i in range(1, b):
    new_ans = (ans[len(ans)-1] * ans[0])%10
    if new_ans in ans: break
    ans.append(new_ans)
  
  k = ans[b % len(ans) -1]
  print(k if k != 0 else 10)