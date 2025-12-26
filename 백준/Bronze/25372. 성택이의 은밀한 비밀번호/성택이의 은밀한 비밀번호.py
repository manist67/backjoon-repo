t = int(input())

for _ in range(t):
  p = input()
  len_p = len(p)
  print( "yes" if len_p >= 6 and len_p <= 9 else "no")