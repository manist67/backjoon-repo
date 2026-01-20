N = int(input())
text = input()

ans = 0
prev = ""
for c in text:
  if c == "." or c == "|" or c == ":" or c == "#":
    ans += int(prev)
    prev = ""
  else:
    prev += c
ans += int(prev)
print(ans)