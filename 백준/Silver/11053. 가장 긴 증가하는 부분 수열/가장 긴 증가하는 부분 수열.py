N = int(input())
A = list(map(int, input().split()))

previous = set([(0,0)])

for i, a in enumerate(A):
  for prev in list(previous):
    if prev[0] < a:
      previous.add(( a, prev[1] + 1 ))

ans_candidate = [ p[1] for p in previous ]
print(max(ans_candidate))