import java.util.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int j = 0 ; j < N; j++) {
            String row = br.readLine();
            for(int i = 0 ; i < M; i++) {
                arr[j][i] = row.charAt(i) - '0';
            }
        }

        long ans = -1;
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                for(int dr = -N + 1; dr < N; dr++) {
                    for(int dc = -M + 1; dc < M; dc++) {
                        if(dr == 0 && dc == 0) {
                            if(check(arr[r][c])) ans = Math.max(arr[r][c], ans);
                            continue;
                        }

                        int currR = r;
                        int currC = c;
                        long num = 0;
                        while(currR >= 0 && currR < N && currC >= 0 && currC < M){
                            num = num * 10 + arr[currR][currC];
                            if(check(num)) ans = Math.max(num, ans);
                            
                            currC += dc;
                            currR += dr;
                        } 
                        
                    }
                }
            }
        }
        
        System.out.println(ans);
    }

    public static boolean check(long num) {
        long root = (long) Math.sqrt(num);
        return root * root == num;
    }
}
