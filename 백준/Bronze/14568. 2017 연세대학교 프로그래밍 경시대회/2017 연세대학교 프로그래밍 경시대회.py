n = int(input())

# 남규 >= 영훈 + 2
# 택희 % 2 == 0
# 택희 a, 영훈 b, 남규 c
cases = []
for i in range(0, n+1):
  for j in range(0, n - i + 1):
    cases.append([i, j, n-(i+j)])

success_cases = []
for case in cases:
  a, b, c, = case
  if a == 0 or b == 0 or c == 0: continue
  if a % 2 != 0: continue
  if c < b + 2: continue
  success_cases.append(case)

print(len(success_cases))