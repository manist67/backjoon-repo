op1, op2 = input().split()
op1 = int(op1[::-1])
op2 = int(op2[::-1])

print( op1 if op1 > op2 else op2)