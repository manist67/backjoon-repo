import sys
N, E = map(int, sys.stdin.readline().split())

graph = {}
for _ in range(E):
  a, b, c = map(int, sys.stdin.readline().split())
  if a not in graph:
    graph[a] = {}
  
  if b not in graph:
    graph[b] = {}

  if b not in graph[a] or graph[a][b] > c:
    graph[a][b] = c
    
  if a not in graph[b] or graph[b][a] > c:
    graph[b][a] = c

v1, v2 = map(int, sys.stdin.readline().split())

import heapq
def dijkstra(size, graph, start):
  queue = []
  heapq.heappush(queue, (0, start))
  
  distances = [ float('inf') for _ in range(size+1)]
  distances[start] = 0

  while len(queue) != 0:
    current_distance, current_node = heapq.heappop(queue)
    if distances[current_node] < current_distance: continue

    if current_node not in graph: continue
    for neighbor in graph[current_node]:
      weight = graph[current_node][neighbor]
      if current_distance + weight > distances[neighbor]: continue

      distances[neighbor] = current_distance + weight
      heapq.heappush(queue, ( current_distance + weight, neighbor ))

  return distances


one_to_all = dijkstra(N, graph, 1)
v1_to_all = dijkstra(N, graph, v1)
v2_to_all = dijkstra(N, graph, v2)

ans = min(one_to_all[v1] + v1_to_all[v2] + v2_to_all[N], one_to_all[v2] + v2_to_all[v1] + v1_to_all[N])
if ans >= float('inf'): print(-1)
else: print(ans)