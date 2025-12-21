t = int(input())

def find_prime(n):
  is_prime = False
  while not is_prime:
    is_prime = True
    for i in range(2, int( n ** (1/2) ) + 1):
      if n % i == 0:
        is_prime = False  
        break
    if not is_prime: n += 1
  
  return n

res = []
for i in range(t):
  n = int(input())
  if n == 0 or n == 1: res.append("2")
  else : res.append(str(find_prime(n)))

print("\n".join(res))