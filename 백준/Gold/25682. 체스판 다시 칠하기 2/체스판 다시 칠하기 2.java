import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        char[][] arr = new char[N][M];
        for(int j = 0 ; j < N; j++) {
            String row = br.readLine();
            for(int i = 0; i <M;i++) arr[j][i] = row.charAt(i);
        }

        int[][] cost = new int[N][M];
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < M; i++) {
                if( (j+i) % 2 == 0 ) { // 0,0 이랑 같아야하는 조건
                    if(arr[j][i] == 'W') cost[j][i] = 1;
                } else {
                    if(arr[j][i] == 'B') cost[j][i] = 1;
                }
            }
        }
        
        int [][] S = new int[N+1][M+1];
        for(int j = 1; j <= N; j++) {
            for(int i = 1; i <= M; i++) {
                S[j][i] = cost[j-1][i-1] + S[j-1][i] + S[j][i-1] - S[j-1][i-1];
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j = K; j <= N; j++) {
            for(int i = K; i <= M; i++) {
                int currentSum = S[j][i] - S[j-K][i] - S[j][i-K] + S[j-K][i-K];
                int whiteCurrentSum = (K*K) - currentSum;
                ans = Math.min(Math.min(currentSum, whiteCurrentSum), ans);
            }
        }

        // for(int j = 0; j < M; j++) {
        //     System.out.println(Arrays.stream(S[j]).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        // }

        System.out.println(ans);        
    }
}
