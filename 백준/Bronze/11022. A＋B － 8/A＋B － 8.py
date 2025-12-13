import sys

t = int(input())
for i in range(t):
  op1, op2 = map(int, input().split())
  print(f"Case #{i+1}: {op1} + {op2} = {op1 + op2}")