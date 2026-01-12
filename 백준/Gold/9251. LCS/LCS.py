a = list(input())
b = list(input())

#ACAYKP
#CAPCAK

dp = [
  [ 0 for _ in range(len(a) + 1) ] for _ in range(len(b) + 1)
]

for i in range(1, len(a) + 1):
  for j in range(1, len(b) + 1):
    if a[i - 1] == b[j - 1]:
      dp[j][i] = dp[j-1][i-1] + 1
    else:
      dp[j][i] = max(dp[j][i-1], dp[j-1][i])
    

print(dp[len(b)][len(a)])