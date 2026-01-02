N = int(input())

prices = []
for _ in range(N):
  prices.append(list(map(int, input().split())))

r,g,b = prices[0]
min_prices = [
  [min(g,b), min(r,b), min(r,g)]
]

def get_min(prices):
  for i in range(1, len(prices)):
    price = prices[i]
    pr, pg, pb = min_prices[i - 1]
    r,g,b = price

    min_prices.append(
      [ 
        min(pg + g, pb + b),
        min(pr + r, pb + b), 
        min(pr + r, pg + g), 
      ]
    )

get_min(prices)

print(min(min_prices[-1]))