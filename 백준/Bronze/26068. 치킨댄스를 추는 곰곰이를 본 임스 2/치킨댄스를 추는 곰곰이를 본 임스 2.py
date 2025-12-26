n = int(input())

res = 0
for _ in range(n):
  d = input()
  remain = int(d[2:])
  if remain <= 90: res+=1

print(res)