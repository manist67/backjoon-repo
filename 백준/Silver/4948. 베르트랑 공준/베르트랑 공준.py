def get_eratosthenes(n, m):
  res = [ True for _ in range(0, m+1)]

  i = 2
  while i <= m:
    if res[i]: 
      for j in range(2, int(m/i) + 1):
        res[ i * j ] = False

    i+=1

  res[0] = False
  res[1] = False

  result = []
  for i, val in enumerate(res):
    if i <= n: continue
    if not val: continue
    result.append(i)

  return result

while True:
  n = int(input())
  if n == 0: break
  print(len(get_eratosthenes(n, 2*n)))