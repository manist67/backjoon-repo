import java.util.*;
import java.io.*;
import java.sql.ResultSet;


public class Main {
    public static class Node {
        int id;
        HashSet<Node> connects = new HashSet<>();
        public Node(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        HashSet<Integer> knowList = new HashSet<>(M); 
        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
        for(int i = 0; i < know; i++) {
            knowList.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            ArrayList<Integer> party = new ArrayList<>(p);
            for(int j = 0 ; j < p; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        Node[] nodes = new Node[N+1];
        for(int i = 1; i <= N; i++) nodes[i] = new Node(i);

        for(ArrayList<Integer> party : parties) {
            for(int i = 0 ; i < party.size(); i++) {
                for(int j = 0; j < party.size(); j++) {
                    if(i==j) continue;
                    Integer p1 = party.get(i);
                    Integer p2 = party.get(j);
                    nodes[p1].connects.add(nodes[p2]);
                    nodes[p2].connects.add(nodes[p1]);
                }
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int k : knowList) { queue.offer(k); }
        boolean[] isVisited = new boolean[N+1];
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            isVisited[curr] = true;
            for(Node connect : nodes[curr].connects) {
                if(isVisited[connect.id]) continue;
                queue.offer(connect.id);
            }
        }
        
        
        int ans = 0;
        for(ArrayList<Integer> party : parties) {
            boolean canAttend = true;
            for(int member : party) {
                if(isVisited[member]) {
                    canAttend = false;
                    break;
                }
            }
            if(canAttend) ans++;
        }

        System.out.println(ans);
    }
}
