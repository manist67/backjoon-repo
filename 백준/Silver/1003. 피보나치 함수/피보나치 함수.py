T = int(input())


z_cache = {}
def z_ans(N):
  global z_cache
  if N == 0: return 1
  elif N == 1: return 0
  elif N == 2: return 1
  a = z_cache[N-1] if N-1 in z_cache else z_ans(N-1)
  z_cache[N-1] = a
  b = z_cache[N-2] if N-2 in z_cache else z_ans(N-2)
  z_cache[N-2] = b
  return a + b



o_cache = {}
def o_ans(N):
  global o_cache
  if N == 0: return 0
  elif N == 1: return 1
  elif N == 2: return 1
  a = o_cache[N-1] if N-1 in o_cache else o_ans(N-1)
  o_cache[N-1] = a
  b = o_cache[N-2] if N-2 in o_cache else o_ans(N-2)
  o_cache[N-2] = b
  return a + b


for _ in range(T):
  N = int(input())
  print(z_ans(N), o_ans(N))