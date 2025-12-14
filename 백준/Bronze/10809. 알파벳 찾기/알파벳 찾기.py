s = list(input())
for i in range(97, 97+26):
  try:
    print(s.index(chr(i)), end=" ")
  except:
    print("-1", end=" ")