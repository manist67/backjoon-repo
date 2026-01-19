from math import factorial
import sys

questions = []
ans_list = []
while True:
  num = sys.stdin.readline().strip()
  if num == "0": 
    break
  questions.append(num)


for num in questions:
  l = len(num)
  ans = 0
  for idx, d in enumerate(num):
    d = int(d)
    ans += factorial(l - idx) * d
  ans_list.append(str(ans))


print("\n".join(ans_list))