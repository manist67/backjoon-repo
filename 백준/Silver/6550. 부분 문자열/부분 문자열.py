while True:
  try:
    s, t = input().split()
    ans = True
    i = 0
    for c in s:
      found = False
      while len(t) > i:
        if t[i] == c: 
          found = True
          i+=1
          break
        i+=1
      if not found:
        ans = False
        break
      
    print("Yes" if ans else "No")
  except:
    break