n = int(input())
ans = 0
questions = map(int, input().split())

for question in questions:
  is_prime = True
  if question == 1:
    continue

  for i in range(2, question):
    if question % i == 0:
      is_prime = False
      break
  if is_prime: ans+=1

print(ans)
