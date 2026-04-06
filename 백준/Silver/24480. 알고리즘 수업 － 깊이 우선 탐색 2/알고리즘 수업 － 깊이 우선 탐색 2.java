import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph.get(to).add(from);
            graph.get(from).add(to);
        }
        for(int i = 0; i<=N; i++) graph.get(i).sort((a,b)->a-b);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int [] order = new int[N+1];
        int lv = 1;
        stack.add(R);
        while(!stack.isEmpty()) {
            Integer curr = stack.pop();
            if(order[curr]>0) continue;
            order[curr] = lv++;

            for(int next : graph.get(curr)) {
                if(order[next]>0) continue;
                stack.push(next);
            }
        }

        for(int i = 1; i <= N; i++) System.out.println(order[i]);
    }
}
