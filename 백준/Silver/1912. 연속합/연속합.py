n = int(input())

items = list(map(int, input().split()))


maximum_list = [ items[0] ]
def get_maximum(items):
  if n == 0: return items[0]

  for i in range(1, len(items)):
    if maximum_list[i-1] + items[i] > items[i]:
      maximum_list.append( maximum_list[i-1] + items[i] )
    else:
      maximum_list.append(items[i])

get_maximum(items)
print(max(maximum_list))