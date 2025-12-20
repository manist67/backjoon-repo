import sys
import random

def quick_sort(arr, start, end):
  if end - start <= 1: return
  i = start
  j = end - 1
  pivot = arr[random.randrange(start, end)]

  while i <= j:
    while arr[i] > pivot:
      i+=1
    
    while pivot > arr[j]:
      j-=1
    
    if i <= j:
      arr[i], arr[j] = arr[j], arr[i]
      i+=1
      j-=1
  
  quick_sort(arr, start, j + 1)
  quick_sort(arr, i, end)

n = int(input())

entered = set()
for i in range(n):
  name, log_type = input().split()
  if log_type == "enter":
    entered.add(name)
  else:
    entered.remove(name)

entered = list(entered)
quick_sort(entered, 0, len(entered))

for i in entered:
  print(i)