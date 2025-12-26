t = int(input())

for i in range(t):
  l_t, w_t, l_e, w_e = map(int, input().split())
  if l_t * w_t > l_e * w_e:
    print("TelecomParisTech")
  elif l_t * w_t < l_e * w_e:
    print("Eurecom")
  else:
    print("Tie")