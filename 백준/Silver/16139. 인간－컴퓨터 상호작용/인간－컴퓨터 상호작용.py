S = input()
q = int(input())
import sys

questions = []

dp = [
  [ 0 ] * (len(S) + 1) for i in range(26)
]

for idx, c in enumerate(S):
  o = ord(c)-97
  for j in range(26):
    if o == j:
      dp[j][idx + 1] = dp[j][idx] + 1
    else: 
      dp[j][idx + 1] = dp[j][idx]


for _ in range(q):
  a, l, r = sys.stdin.readline().split()
  questions.append( [a, int(l), int(r)] )

ans = []
for question in questions:
  a, l, r = question
  o = ord(a)-97
  ans.append(str(dp[o][r + 1] - dp[o][l]))

print("\n".join(ans))