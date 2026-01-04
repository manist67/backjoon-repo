N = int(input())
stairs = [ int(input()) for _ in range(N) ]

if N == 1: 
  print(stairs[0])
else:
  res = [
    [ stairs[0], stairs[0] ],
    [ stairs[1], stairs[0] + stairs[1] ],
  ]

  for i in range(2, N):
    stair = stairs[i]

    prev_prev = res[i-2]
    prev = res[i-1]
    
    # first[1] + stairs : 1회 
    # second[0] + stairs : 2회

    res.append([
      max(prev_prev) + stair, prev[0] + stair
    ])

  print(max(res[len(res)-1]))