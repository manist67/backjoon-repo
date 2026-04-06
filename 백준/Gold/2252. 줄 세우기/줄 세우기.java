import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]> students = new ArrayList<>();
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            students.add(new int[] { A, B });
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N; i++) graph.add(new ArrayList<>());

        int[] inDegrees = new int[N + 1];

        for(int i = 0 ; i < M; i++) {
            int[] li = students.get(i);
            inDegrees[li[1]]++;
            graph.get(li[0]).add(li[1]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegrees[i] == 0) queue.add(i);
        }
        
        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            answer.add(curr);

            for(int next : graph.get(curr) ) {
                inDegrees[next]--;
                if(inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        
        System.out.println( answer.stream().map(String::valueOf).collect(Collectors.joining(" ")) );
    }
}
