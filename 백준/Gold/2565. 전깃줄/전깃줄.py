n = int(input())
lines = [
  tuple(map(int, input().split())) for i in range(n)
]

lines.sort(key=lambda x: x[0])

A = [ x[1] for x in lines ]

dp1 = [ 1 ] * n
for i in range(n):
  for j in range(i):      
    if A[i] > A[j]:
      dp1[i] = max(dp1[i], dp1[j] + 1)

# print(A)
# print(dp1)

print(n - max(dp1))