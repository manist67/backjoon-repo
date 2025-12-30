N = int(input())

ability_set = [
  list(map(int,input().split())) for _ in range(N)
]

def combain(n, k):
  result = []
  path = []

  def backtracking(s):
    if len(path) == k:
      result.append(path[:])
      return
    
    for i in range(s, n):
      path.append(i)
      backtracking(i+1)
      path.pop()
  
  backtracking(0)
  return result

teams = combain(N, N//2)
ans = 1000000

def get_score(S, team):
  score = 0
  team_len = len(team)
  for i in range(team_len):
    a = team[i]
    for j in range(i+1, team_len):
      b = team[j]
      score += S[a][b] + S[b][a]
    
  return score


min_val = 10000000
total_team_len = len(teams)
for i in range(0, len(teams)//2):
  diff = abs(get_score(ability_set, teams[i]) - get_score(ability_set, teams[total_team_len - i - 1]))
  if min_val > diff:
    min_val = diff

print(min_val)