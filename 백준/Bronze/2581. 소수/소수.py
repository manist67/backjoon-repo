M = int(input())
N = int(input())
ans = []
for question in range(M, N+1):
  is_prime = True
  if question == 1:
    continue

  for i in range(2, question):
    if question % i == 0:
      is_prime = False
      break
  if is_prime: ans.append(question)

if len(ans) == 0: print("-1")
else:
  print(sum(ans))
  print(ans[0])
