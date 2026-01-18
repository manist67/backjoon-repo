N, M = map(int, input().split())
arr = list(map(int, input().split()))

dp = [ 0 ] * (N + 1)
counts = [ 0 ] * M

for i in range(1, N + 1):
  dp[i] = dp[i-1] + arr[i-1]
  counts[dp[i] % M] += 1

ans = counts[0]

for n in counts:
  if n < 2: continue
  ans += n*(n-1)/2

print(int(ans))