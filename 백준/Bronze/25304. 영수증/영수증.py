X = int(input())
N = int(input())

for i in range(N):
  price, n = map(int, input().split())
  X -= (price * n)

print("Yes" if X == 0 else "No")
