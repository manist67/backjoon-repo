c = int(input())
for _ in range(c):
  r, s = input().split()
  s = list(s)
  res = [ c * int(r) for c in s]
  print("".join(res))