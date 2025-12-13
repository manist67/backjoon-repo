op1= input()
op2 = input()

op1 = int(op1)
for i in reversed(op2):
  print(op1 * int(i))

print(op1 * int(op2))