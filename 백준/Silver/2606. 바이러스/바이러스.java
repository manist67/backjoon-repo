import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
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
        boolean [] ihaveavirus = new boolean[N+1];
        ihaveavirus[1] = true;

        stack.add(1);
        while(!stack.isEmpty()) {
            Integer curr = stack.poll();
            ihaveavirus[curr] = true;

            for(int next : graph.get(curr)) {
                if(ihaveavirus[next]) continue;
                stack.add(next);
            }
        }

        System.out.println(
            IntStream.range(0, ihaveavirus.length)
            .mapToObj(i->ihaveavirus[i])
            .filter(b -> b)
            .count() - 1
        );
    }
}
