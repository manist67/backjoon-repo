T = int(input())

prev = [1, 1, 1 ]
def wave():
  for i in range(3, 101):
    prev.append(prev[i-3] + prev[i-2])

wave()
for i in range(T):
  print(prev[int(input()) - 1])