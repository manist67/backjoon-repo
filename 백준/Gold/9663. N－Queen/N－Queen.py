def back_tracking(n, x, y, poses: list, pos_x: set, diagnose_a: set, diagnose_b: set):

  if len(poses) + 1 == n: 
    return 1
  
  poses.append((x,y))
  pos_x.add(x)
  diagnose_a.add(x-y)
  diagnose_b.add(x+y)

  ans = 0
  
  for i in range(n):
    if i in pos_x: continue
    if (i-(y+1)) in diagnose_a: continue
    if (i+(y+1)) in diagnose_b: continue
    ans += back_tracking(n, i, y+1, poses, pos_x, diagnose_a, diagnose_b)

  poses.pop()
  pos_x.remove(x)
  diagnose_a.remove(x-y)
  diagnose_b.remove(x+y)

  return ans
  

def queen_problem(n):
  ans = 0
  for i in range(n):
    ans += back_tracking(n, i, 0, [], set(), set(), set())
  
  return ans

n = int(input())

# logic
ans = queen_problem(n)
print(ans)
# end: logic
