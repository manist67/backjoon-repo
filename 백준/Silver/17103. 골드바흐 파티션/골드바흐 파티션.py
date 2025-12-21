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

  return result, res

n = int(input())

questions = []
for i in range(n):
  questions.append(int(input()))

primes, array_map = get_eratosthenes(1, max(0, *questions) + 1) 
for question in questions:
  res_partition = 0
  
  for i in primes:
    if i > question / 2: break
    if array_map[(question - i)]:
      res_partition += 1

  print(res_partition)