from collections import deque

N = int(input())

balloons = [ (index+1, int(val)) for index, val in enumerate(input().split()) ]

res = []
i = 0
while True:
  i = i % len(balloons)
  [ balloons_idx, next ] = balloons.pop(i)
  res.append(balloons_idx)
  if next > 0:
    i = i + next - 1
  else:
    i = i + next
  
  if len(balloons) == 0: break

print(" ".join(map(str,res)))