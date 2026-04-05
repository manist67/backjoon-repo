import java.util.*;

class Node implements Comparable<Node> {
    int distance;
    int index;
    Node(int index, int distance) {
        this.distance = distance;
        this.index = index;
    }
    
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
    
}

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i<= n; i++) graph.add(new ArrayList<>());
        for(int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }
        
        int[] startPointCosts = dijkstra(n, s, graph);
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int[] costs = dijkstra(n, i, graph);
            int calculateCost = startPointCosts[i] + costs[a] + costs[b];
            
            answer = Math.min(calculateCost, answer);
        }
        
        return answer;
    }
    
    int[] dijkstra(int n, int startIdx, List<List<Node>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        pq.add(new Node(startIdx, 0));
        dist[startIdx] = 0;
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(dist[curr.index] < curr.distance) continue;
            
            for(Node next : graph.get(curr.index)) {
                int newCost = curr.distance + next.distance;
                if(newCost < dist[next.index]) {
                    dist[next.index] = newCost;
                    pq.add(new Node(next.index, newCost));
                }
            }
        }
        
        return dist;
    }
}