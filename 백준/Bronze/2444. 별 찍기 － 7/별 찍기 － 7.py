c = int(input())
for i in range(c-1):
  for j in range(c - i - 1):
    print(" ", end="") 
  for j in range(i):
    print("*", end="")
  print("*", end="")
  for j in range(i):
    print("*", end="")
  print("")

for i in range(c):
  for j in range(i):
    print(" ", end="") 
  
  for j in range(c - i - 1):
    print("*", end="")
  
  print("*", end="")
  
  for j in range(c - i - 1):
    print("*", end="")

  print("")
