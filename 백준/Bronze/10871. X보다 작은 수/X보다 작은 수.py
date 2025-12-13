T, X = map(int, input().split())
arr = list(map(int, input().split()))


print(" ".join(list(map(str, filter(lambda x : x < X, arr)))))