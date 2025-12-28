board = [
  [ int(x) for x in input().split() ] for _ in range(9)
]

def get_candidate(board, blank):
  candidates = set(range(1, 10))
  x, y = blank
  for i in range(9):
    if board[y][i] in candidates: candidates.remove(board[y][i])
    if board[i][x] in candidates: candidates.remove(board[i][x])

  start_idx = x//3 * 3, y//3 * 3
  for i in range(3):
    for j in range(3):
      if board[start_idx[1] + i][start_idx[0] + j] in candidates:
        candidates.remove(board[start_idx[1] + i][start_idx[0] + j])

  return candidates

blanks = []
for j in range(9):
  for i in range(9):
    if board[j][i] == 0: 
      blanks.append((i,j))

remain_block_x = [ [ False for _ in range(9) ] for i in range(9) ]
remain_block_y = [ [ False for _ in range(9) ] for i in range(9) ]
remain_block_sq = [ [ False for _ in range(9) ] for i in range(9) ]

for j in range(9):
  for i in range(9):
    if board[i][j] == 0: continue
    remain_block_x[j][ board[i][j] - 1 ] = True

for j in range(9):
  for i in range(9):
    if board[j][i] == 0: continue
    remain_block_y[j][ board[j][i] - 1 ] = True
    

for i in range(9):
  for x in range(0, 3):
    for y in range(0, 3):
      if board[(i//3 * 3) + y][(i%3 * 3) + x] == 0: continue
      remain_block_sq[i][ board[(i//3 * 3) + y][(i%3 * 3) + x] - 1 ] = True

def sudoku(blanks: list):
  if len(blanks) == 0: return True

  candidates = get_candidate(board, blanks[0])
  minimum_candidate_idx = 0

  for idx in range(1, len(blanks)):
    blank_candidates = get_candidate(board, blanks[idx])
    if len(blank_candidates) < len(candidates):
      minimum_candidate_idx = idx
      candidates = blank_candidates
  
  blank = blanks.pop(minimum_candidate_idx)

  x, y = blank
  side = y // 3 * 3 + x // 3
  
  for i in candidates:
    if remain_block_x[x][i - 1] or remain_block_y[y][i - 1] or remain_block_sq[side][i - 1]:
      continue

    board[y][x] = i
    remain_block_x[x][i - 1] = True
    remain_block_y[y][i - 1] = True
    remain_block_sq[side][i - 1] = True
    if sudoku(blanks): return True
    board[y][x] = 0
    remain_block_x[x][i - 1] = False
    remain_block_y[y][i - 1] = False
    remain_block_sq[side][i - 1] = False
  
  blanks.append(blank)
  return False


sudoku(blanks)
for i in range(9):
  print(" ".join(map(str, board[i])))