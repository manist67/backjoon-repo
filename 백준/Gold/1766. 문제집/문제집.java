import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<int[]> beforeSolve = new ArrayList<>();
        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            beforeSolve.add(new int[] { from, to });
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> inDegrees = new ArrayList<>(N+1);
        for(int i = 0 ; i <= N; i++) inDegrees.add(0);
        for(int[] bs : beforeSolve) {
            int A = bs[0], B = bs[1];
            Integer degree = inDegrees.get(B);
            inDegrees.set(B, degree + 1);
            graph.get(A).add(B);
        }

        for(int i = 1; i<= N; i++) {
            if(inDegrees.get(i) == 0) queue.add(i);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            Integer problem = queue.poll();
            answer.add(problem);
            for(Integer nextProblem : graph.get(problem)) {
                Integer id = inDegrees.get(nextProblem);
                if(id - 1 == 0) queue.add(nextProblem);
                inDegrees.set(nextProblem, id-1);
            }
        }
        
        System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")) );
    }
}
