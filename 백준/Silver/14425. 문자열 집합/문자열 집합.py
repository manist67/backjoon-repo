n, m = map(int, input().split())

N = set( [ input() for _ in range(n) ] )
M = [ input() for _ in range(m) ] 

res = 0
for x in M:
  if x in N:
    res += 1
    
print(res)