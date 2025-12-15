op1, op2 = map(int, input().split())

c = 1
latest_divisor = 1
divisor_index = 0
while c <= op1:
  if op1 % c == 0: 
    divisor_index += 1
    latest_divisor = c
    if divisor_index == op2: break
  c+=1
print(0 if divisor_index < op2 else latest_divisor)