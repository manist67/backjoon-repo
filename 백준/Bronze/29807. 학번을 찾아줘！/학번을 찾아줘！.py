T = int(input())
scores = list(map(int, input().split())) + [ 0, 0, 0, 0, 0 ]

ans = 0
if scores[0] > scores[2]:
  ans += abs(scores[0] - scores[2]) * 508
else:
  ans += abs(scores[0] - scores[2]) * 108

if scores[1] > scores[3]:
  ans += abs(scores[3] - scores[1]) * 212
else:
  ans += abs(scores[3] - scores[1]) * 305

ans += scores[4] * 707

ans *= 4763
print(ans)