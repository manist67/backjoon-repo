students = list(range(30))
for _ in range(28):
  i = int(input())
  students[i-1] = False

no_homework = list(filter(lambda sid: type(sid) is not bool, students))
print(min(no_homework)+1)
print(max(no_homework)+1)