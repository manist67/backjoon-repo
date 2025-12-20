import sys
n = int(input())
val = []
for _ in range(n):
    line = sys.stdin.readline()
    val.append(int(line.strip()))

val.sort()
res = [ str(i) for i in val ]

print("\n".join(res))