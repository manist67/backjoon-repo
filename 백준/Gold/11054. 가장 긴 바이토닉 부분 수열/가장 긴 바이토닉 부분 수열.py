N = int(input())
A = list(map(int, input().split()))

dp_upper = [ 1 ] * N
dp_upper_to_lower = [ 1 ] * N

for i in range(N):
  for j in range(i):
    if A[i] > A[j]:
      dp_upper[i] = max(dp_upper[i], dp_upper[j] + 1)
    elif A[i] < A[j]:
      dp_upper_to_lower[i] = max(dp_upper_to_lower[i], dp_upper_to_lower[j] + 1)
  dp_upper_to_lower[i] = max(dp_upper[i], dp_upper_to_lower[i])

print(max(max(dp_upper), max(dp_upper_to_lower)))