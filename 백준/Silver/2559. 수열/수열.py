# 10 2
# 3 -2 -4 -9 0 3 7 13 8 -3

n, K = map(int, input().split())
temps = list(map(int,input().split()))

dp = [
  sum(temps[0:K])
]
for i in range(K, n):
  dp.append(
    dp[-1] + temps[i] - temps[i - K]
  )
print(max(dp))