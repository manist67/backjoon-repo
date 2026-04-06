import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < t; i++) {
            solution(br);
        }
    }

    public static void solution(BufferedReader br) throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> rank = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        rank.add(0); // index 맞추기용
        for(int i = 1; i <= n; i++ ) {
            rank.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> changedList = new ArrayList<>();

        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            changedList.add(new int[] { from, to });
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] inDegrees = new int[n+1];
        
        int[][] graph = new int[n+1][];
        for(int i = 0; i <= n; i++) graph[i] = new int[n+1];

        for(int i = 1; i <= n;i++) {
            for(int j = i + 1; j <= n; j++) {
                graph[rank.get(i)][rank.get(j)] = 1;
                inDegrees[rank.get(j)]++;
            }
        }

        for(int[] changed : changedList) {
            int a = changed[0], b = changed[1];
            if(graph[a][b] == 1) {
                graph[a][b] = 0;
                graph[b][a] = 1;
                inDegrees[b]--;
                inDegrees[a]++;
            } else {
                graph[a][b] = 1;
                graph[b][a] = 0;
                inDegrees[b]++;
                inDegrees[a]--;
            }
        }

        for(int i = 1; i <= n; i++){
            if(inDegrees[i] == 0) queue.add(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int team = queue.poll();
            answer.add(team);
            for(int i = 1; i <= n; i++) {
                if(graph[team][i] != 1) continue;
                inDegrees[i]--;
                if(inDegrees[i] == 0) {
                    queue.add(i);
                }
            }
        }

        // System.out.println( "rank >>> " + rank.stream().map(String::valueOf).collect(Collectors.joining(" ")) );
        // System.out.println( "queue >>> " + queue.stream().map(String::valueOf).collect(Collectors.joining(" ")) );
        if(answer.size() == n) System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")) );
        else System.out.println("IMPOSSIBLE");
    }
}
