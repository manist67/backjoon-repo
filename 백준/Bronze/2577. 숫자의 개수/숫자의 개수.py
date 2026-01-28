s = 1
for i in range(3):
  s *= int(input())

ans = [ 0 ] * 10
for c in str(s):
  ans[int(c)] += 1

for a in ans:
  print(a)
