import sys

def gcd(a,b):
  x = max(a, b)
  y = min(a, b)

  r = x % y
  if r == 0:
    return y
  return gcd(y, r)

n = int(input())
arr = []
subs = []
lmss =[]
for _ in range(n):
  line = sys.stdin.readline()
  x= int(line.strip())
  arr.append(x)

for i in range(1, len(arr)):
  subs.append(arr[i] - arr[i-1])

common_gcd = subs[0]
for i in range(1, len(subs)):
  common_gcd = gcd(subs[i], common_gcd)


res = 0
for sub in subs:
  res += (sub // common_gcd) -1
print(res)