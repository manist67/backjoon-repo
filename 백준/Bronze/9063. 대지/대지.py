n = int(input())
x1, y1, x2, y2 = 10_001, 10_001, -10_001, -10_001

for i in range(n):
  x, y = map(int, input().split())
  x1 = min(x, x1)
  y1 = min(y, y1)

  x2 = max(x, x2)
  y2 = max(y, y2)

print(f"{(x2-x1) * (y2-y1)}")