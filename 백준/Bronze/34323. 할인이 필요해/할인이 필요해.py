N, M, S = map(int, input().split())
print(min( S * M, int(S*(M+1)*(100-N)/100) ))