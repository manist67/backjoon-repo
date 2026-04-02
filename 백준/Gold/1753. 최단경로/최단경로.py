V, E = map(int, input().split())
K = int(input())

import heapq

edges = {

}

for _ in range(E):
  u, v, w = map(int, input().split())
  if edges.get(u) is None:
    edges[u] = {}

  if edges[u].get(v) is None or edges[u][v] > w:
    edges[u][v] = w
  

def dijkstra(size, graph, start):
  dists = [ 999999999 for _ in range(size+1) ]
  dists[start] = 0
  queue = []
  heapq.heappush(queue, (0, start))
  
  while len(queue) != 0:
    current_dist, current_node = heapq.heappop(queue)
    
    if dists[current_node] < current_dist: continue
    if graph.get(current_node) is None: continue

    for key in graph[current_node]:
      w = graph[current_node][key]
      if w == 999: continue
      distance = current_dist + w
      if distance < dists[key]:
        dists[key] = distance
        heapq.heappush(queue, (distance, key))

  return dists


distances = dijkstra(V, edges, K)
ans = [ distances[i] for i in range(V+1) ]

for i in range(1, V+1):
  if ans[i] == 999999999: print("INF")
  else: print(ans[i])

