a,b,c = map(int, input().split())

if a == b and b == c:
  print(10000+a*1000)
elif a != b and b != c and c != a: print(max(a,b,c)*100)
else:
  if a==b: m = a
  elif b==c: m = b
  else: m = c
  print(1000+m*100)