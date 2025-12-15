def find_divisor(num):
  res = []
  for i in range(1, num):
    if num % i == 0: res.append(i)

  return res

while True:
  op = int(input())
  if op == -1: break
  res = find_divisor(op)
  if sum(res) != op: print(f"{op} is NOT perfect.")
  else: print(f"{op} = {" + ".join(map(str,res))}")