T = int(input())
import math
for _ in range(T):
  N, C = map(int, input().split())
  print(math.ceil(N/C))