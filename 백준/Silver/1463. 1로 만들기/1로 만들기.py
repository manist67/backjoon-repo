X = int(input())

methods = [
  -1, # 0인 경우 불가
  0, # 1
  1, # 2
  1, # 3
]

for i in range(4, X+1):
  c = []
  if i % 3 == 0:
    c.append(methods[i//3] + 1)
  if i % 2 == 0:
    c.append(methods[i//2] + 1)
  c.append(methods[i-1] + 1)
  methods.append(min(c))

print(methods[X])