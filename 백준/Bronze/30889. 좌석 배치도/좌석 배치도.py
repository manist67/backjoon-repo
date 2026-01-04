n = int(input())

seats = [
  [ "." for _ in range(20) ] for _ in range(10)
]
for _ in range(n):
  seat = list(input())
  row = ord(seat[0])-65
  col = int("".join(seat[1:]))-1
  seats[row][col] = "o"

for row in seats:
  print("".join(row))