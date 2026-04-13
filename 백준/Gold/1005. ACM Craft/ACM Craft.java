import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    public static class Task {
        int buildTime;
        ArrayList<Task> before;
        public Task(int buildTime) {
            this.buildTime = buildTime;
            this.before = new ArrayList<>();
        }

        public void addTask(Task task) {
            before.add(task);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] buildTimes = new int[N+1];
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(N+1);
            for(int k = 0 ; k <= N; k++) adj.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                buildTimes[j] = Integer.parseInt(st.nextToken());
            }
    
            for(int j = 0; j < K; j++) {            
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                adj.get(X).add(Y);
            }
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            
            System.out.println(solution(N, buildTimes, adj, W));
        }
    }

    public static int solution(int N, int[] buildTimes, ArrayList<ArrayList<Integer>> adj, int W) {
        int[] inDegrees = new int[N+1];
        int[] resultTime = Arrays.copyOf(buildTimes, buildTimes.length);

        for(int i = 1; i <= N; i++) {
            for(int n : adj.get(i)) inDegrees[n]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>(); 
        for(int next = 1 ; next <= N; next++) {
            if(inDegrees[next] == 0) queue.offer(next);
        }
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : adj.get(current)) {
                resultTime[next] = Math.max(resultTime[next], resultTime[current] + buildTimes[next]);
                inDegrees[next]--;

                if(inDegrees[next] == 0) queue.offer(next);
            }
            
        }

        return resultTime[W];
    }
}
