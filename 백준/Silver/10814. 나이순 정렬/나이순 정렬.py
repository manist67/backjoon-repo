import sys
import random


def quick_sort(arr, start, end, diff):
  if end <= start: return

  i = start
  j = end
  pivot = arr[random.randrange(start, end + 1)]
  while i <= j:
    while diff(arr[i], pivot):
      i += 1
    
    while diff(pivot, arr[j]):
      j -= 1
    
    if i <= j:
      arr[i], arr[j] = arr[j], arr[i]
      i += 1
      j -= 1

  quick_sort(arr, start, j, diff)
  quick_sort(arr, i, end, diff)

n = int(input())
arr = []
for i in range(n):
  line = sys.stdin.readline()
  age, name = line.strip().split()
  arr.append( ( int(age), name, i ) )

def diff_func(a, b):
  if a[0] < b[0]:
    return True
  elif a[0] == b[0]:
    return a[2] < b[2]

  return False

arr = list(set(arr))
quick_sort(arr, 0, len(arr) - 1, diff_func)

print("\n".join(map(lambda x: f"{x[0]} {x[1]}", arr)))