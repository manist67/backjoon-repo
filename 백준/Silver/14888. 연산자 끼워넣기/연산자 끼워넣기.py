from collections import deque
N = int(input())

operands = deque(map(int, input().split()))
operators = list(map(int, input().split())) # [ 0 0 1 0 ]

def div(x, y):
  if x < 0: return -1 * ( -1 * x // y )
  else: return x // y


def calculate(operands: deque, operators: list, is_max: bool):
  val = operands.pop()
  
  res = []
  for idx, reamin in enumerate(operators):
    if reamin == 0: continue

    operators[idx] -= 1
    before_calculated = calculate(operands, operators, is_max)
    if idx == 0: # 더하기
      if is_max: res.append(max(before_calculated) + val)
      else: res.append(min(before_calculated) + val)

    elif idx == 1: # 빼기
      if is_max: res.append(max(before_calculated) - val)
      else: res.append(min(before_calculated) - val)

    elif idx == 2: # 곱하기
      if is_max: res.append(max(before_calculated) * val)
      else: res.append(min(before_calculated) * val)

    elif idx == 3: # 나누기
      if is_max: res.append(div(max(before_calculated), val))
      else: res.append(div(min(before_calculated), val))

    operators[idx] += 1

  operands.append(val)
  if len(res) == 0: return [ val ]
  return res



print(max(calculate(operands, operators, True)))
print(min(calculate(operands, operators, False)))