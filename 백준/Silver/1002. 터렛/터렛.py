T = int(input())

for i in range(T):
  x1, y1, r1, x2, y2, r2 = map(int, input().split())
  if x1 != x2 or y1 != y2:
    distance =  (x2-x1)**2 + (y2-y1)**2
    if distance == (r1 + r2) **2:
      print(1)
    elif distance == (r1 - r2) **2:
      print(1)
    elif distance > (r1 + r2) **2 or distance < (r1-r2)**2:
      print(0)
    else:
      print(2)
  elif x1 == x2 and y1 == y2:
    print(-1 if r1 == r2 else 0)