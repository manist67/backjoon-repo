x, y, w, h = map(int, input().split())

res = min(abs(w - x), abs(x), abs(y), abs(h-y))
print(res)