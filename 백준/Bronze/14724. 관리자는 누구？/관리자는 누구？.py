N = int(input())

groups = [
  "PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY"
]

max_score = 0
max_idx = -1
for i in range(9):
  score = max(map(int, input().split()))
  if max_score > score: continue
  max_score = score
  max_idx = i

print(groups[max_idx])