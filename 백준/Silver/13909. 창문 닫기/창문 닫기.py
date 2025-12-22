N = int(input())

is_perfect_number = False
while not is_perfect_number:
  if int(N ** (1/2)) ** 2 == N:
    is_perfect_number = True
    break
  N-=1

print(int(N ** (1/2)))