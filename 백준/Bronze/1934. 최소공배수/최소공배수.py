def gcd(a,b):
  r = a % b
  if r == 0:
    return b
  return gcd(b, r)

n = int(input())
for i in range(n):
  a, b = map(int, input().split())
  _min = min(a,b)
  _max = max(a,b) 
  print(int(_max * _min / gcd(_max, _min)))