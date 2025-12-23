import sys
from collections import deque

N = int(input())

deck = deque()
res = []
for i in range(N):
  command = list(map(int, sys.stdin.readline().split()))

  if command[0] == 1:
    deck.appendleft(command[1])
  elif command[0] == 2:
    deck.append(command[1])
  elif command[0] == 3:
    res.append(deck.popleft() if len(deck) > 0 else -1)
  elif command[0] == 4:
    res.append(deck.pop() if len(deck) > 0 else -1)
  elif command[0] == 5:
    res.append(len(deck))
  elif command[0] == 6:
    res.append(0 if len(deck) > 0 else 1)
  elif command[0] == 7:
    res.append(deck[0] if len(deck) > 0 else -1)
  elif command[0] == 8:
    res.append(deck[len(deck)-1] if len(deck) > 0 else -1)

print("\n".join(map(str, res)))