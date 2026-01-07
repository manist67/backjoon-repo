n = int(input())
wines = [ int(input()) for _ in range(n) ]

if n <= 2:
  print(sum(wines))
else:
  wine_tasts = [
    [ 0, wines[0], wines[0] ],
    [ 0, wines[1], wines[0] + wines[1] ]
  ]

  for i in range(2, len(wines)):
    wine_tasts.append(
      [ 
        max( wine_tasts[i-1][0], wine_tasts[i-1][1], wine_tasts[i-1][2] )
        , max(wine_tasts[i-1][0] + wines[i], 
          max( wine_tasts[i-2][0], wine_tasts[i-2][1], wine_tasts[i-2][2] ) + wines[i])
        , wine_tasts[i-1][1] + wines[i]
      ]
    )

  print(max(wine_tasts[n-1]))