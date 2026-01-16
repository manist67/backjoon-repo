S = input()
q = int(input())
import sys

questions = []
search_alphabets = set()

idx_need_to_know = {}
alphabet_count = {}

for _ in range(q):
  alphabet, l, r = sys.stdin.readline().split()
  l, r = int(l), int(r)
  questions.append((alphabet, l, r))
  
  if alphabet not in search_alphabets: 
    alphabet_count[alphabet] = 0
    search_alphabets.add(alphabet)

  if l not in idx_need_to_know:
    idx_need_to_know[l] = set()
    
  if l-1 not in idx_need_to_know:
    idx_need_to_know[l-1] = set()

  idx_need_to_know[l].add(alphabet)
  idx_need_to_know[l-1].add(alphabet)

  if r not in idx_need_to_know:
    idx_need_to_know[r] = set()
  idx_need_to_know[r].add(alphabet)


ans = {}
for key in idx_need_to_know.keys():
  ans[key] = { a: 0  for a in idx_need_to_know[key] }

# print(search_alphabets)

keys = ans.keys()
for idx, c in enumerate(list(S)):
  if c in search_alphabets:
    alphabet_count[c] += 1
  if idx in keys:
    for k in ans[idx].keys():
      ans[idx][k] = alphabet_count[k]

results = []
for question in questions:
  alphabet, l, r = question
  results.append(ans[r][alphabet] - ans[l-1][alphabet])


print("\n".join(map(str, results)))