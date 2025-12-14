import statistics

N = int(input())

scores = list(map(int, input().split()))

M = max(scores)
scores = [ (score / M * 100) for score in scores ]
mean = statistics.mean(scores)

print(mean)
