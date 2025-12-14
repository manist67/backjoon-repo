res = [ 1, 1, 2, 2, 2, 8 ]
question = list(map(int, input().split()))

print(" ".join( [str(res[i]-question[i]) for i in range(len(res))] ))