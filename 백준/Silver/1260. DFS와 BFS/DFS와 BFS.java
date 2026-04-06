import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph.get(to).add(from);
            graph.get(from).add(to);
        }
        

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean [] dfsIsVisit = new boolean[N+1];
        boolean [] bfsIsVisit = new boolean[N+1];
        ArrayList<Integer> dfsAnswer = new ArrayList<>();
        ArrayList<Integer> bfsAnswer = new ArrayList<>();

        for(int i = 1; i<=N; i++) graph.get(i).sort((a,b)->b-a);
        stack.push(V);
        while(!stack.isEmpty()) {
            Integer curr = stack.pop();
            if(dfsIsVisit[curr]) continue;
            dfsIsVisit[curr] = true;
            dfsAnswer.add(curr);

            for(int next : graph.get(curr)) {
                if(dfsIsVisit[next]) continue;
                stack.push(next);
            }
        }
        
        for(int i = 1; i<=N; i++) graph.get(i).sort((a,b)->a-b);
        queue.add(V);
        bfsIsVisit[V] = true;
        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            bfsAnswer.add(curr);

            for(int next : graph.get(curr)) {
                if(bfsIsVisit[next]) continue;
                bfsIsVisit[next] = true;
                queue.add(next);
            }
        }

        System.out.println( dfsAnswer.stream().map(String::valueOf).collect(Collectors.joining(" ")) );
        System.out.println( bfsAnswer.stream().map(String::valueOf).collect(Collectors.joining(" ")) );
    }
}
