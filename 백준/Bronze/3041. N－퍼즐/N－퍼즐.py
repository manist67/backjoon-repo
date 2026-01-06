puzzles = [
  list(input()) for _ in range(4)
]

res = 0
for j in range(4):
  for i in range(4):
    if puzzles[j][i] == ".": continue
    c = ord(puzzles[j][i]) - 65
    origin_j = c // 4
    origin_i = c % 4

    res += (abs(i - origin_i) + abs(j - origin_j))
print(res)