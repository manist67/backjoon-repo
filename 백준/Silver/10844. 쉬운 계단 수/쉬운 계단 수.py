N = int(input())
last_number = [
  [ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 ]
]
for i in range(1, N):
  new_number_set = []
  previous_number_set = last_number[i-1]
  for j in range(0, 10):
    if j == 0: 
      new_number_set.append(
        previous_number_set[1]
      )
    elif j == 9:
      new_number_set.append(
        previous_number_set[8]
      )
    else:
      new_number_set.append(
        previous_number_set[j-1] + previous_number_set[j+1]
      )
  last_number.append(new_number_set)

res = last_number[-1]
print(sum(res)%1_000_000_000)

