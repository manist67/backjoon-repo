while True:
  try:
    op1, op2 = map(int, input().split())
    print(op1+op2)
  except:
    break