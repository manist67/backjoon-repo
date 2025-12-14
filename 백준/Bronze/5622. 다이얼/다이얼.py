keypad = [
  "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
]

s = list(input())
sum = 0
for c in s:
  for idx, key in enumerate(keypad):
    if c in key:
      time = idx + 3
      break
  sum += time

print(sum)