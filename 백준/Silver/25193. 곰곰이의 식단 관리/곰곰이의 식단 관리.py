import math
N = int(input())
C = list(input()).count("C")

print(
  math.ceil(C / (N-C + 1))
)