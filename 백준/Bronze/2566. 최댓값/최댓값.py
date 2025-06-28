line = []
max_val = 0
max_i = 0
max_j = 0

for j in range(0, 9):
    line = map(int, input().split(" "))
    for i, val in enumerate(line):
        if max_val < val:
            max_i = i
            max_j = j
            max_val = val
print(max_val)
print(f"{max_j + 1} {max_i + 1}")
