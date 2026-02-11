S = list(input())
S.reverse()

ans = 0
for i in range(0, len(S)):
  c = S[i]
  if ord(c) >= 65:
    ans += (ord(c)-55) * (16**i)
  else:
    ans += (ord(c)-48) * (16**i)

print(ans)