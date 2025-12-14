import math

N, M = map(int, input().split())
buckets = list(range(1, N+1))
for _ in range(M):
  i, j = map(lambda x: int(x)-1, input().split())
  k = 0
  while k < math.ceil((j-i)/2):
    buckets[i+k], buckets[j-k] = buckets[j-k], buckets[i+k]
    k+=1

print(" ".join(map(str, buckets)))

