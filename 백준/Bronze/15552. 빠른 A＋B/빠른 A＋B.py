import sys

t = int(input())
for i in range(t):
  print(sum(map(int, sys.stdin.readline().rstrip().split())))