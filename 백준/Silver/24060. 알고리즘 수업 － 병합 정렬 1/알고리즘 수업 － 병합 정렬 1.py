order = []
def merge_sort(arr, l, r):
  if r <= l: return
  c = (r+l)//2
  merge_sort(arr, l, c) 
  merge_sort(arr, c+1, r)
  merge(arr, l, c, r)


def merge(arr, l, c, r):
  global order
  temp = []
  i, j = l, c + 1
  while i <= c and j <= r:
    if arr[i] < arr[j]:
      temp.append(arr[i])
      i+=1
    else:
      temp.append(arr[j])
      j+=1
  
  while i <= c:
    temp.append(arr[i])
    i+=1
  while j <= r:
    temp.append(arr[j])
    j+=1

  i,t = l, 0
  while i <= r:
    arr[i] = temp[t]
    order.append(arr[i])
    i+=1
    t+=1


N, K = map(int, input().split())
arr = list(map(int, input().split()))

merge_sort(arr, 0, N-1)
if len(order) < K:
  print(-1)
else:
  print(order[K-1])