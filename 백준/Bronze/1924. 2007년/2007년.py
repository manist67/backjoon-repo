months = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

m, d = map(int, input().split())
a = d

for i in range(0, m - 1):
    a += months[i]

week = [ "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
print(week[a % 7])