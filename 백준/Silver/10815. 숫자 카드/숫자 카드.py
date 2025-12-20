n = input()
your_card = set( input().split() )

m = input()
my_card = input().split()

res = [
  "1" if x in your_card else "0" for x in my_card
]

print(" ".join(res))